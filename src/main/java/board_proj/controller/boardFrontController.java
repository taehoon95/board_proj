package board_proj.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_proj.action.Action;
import board_proj.action.NullAction;
import board_proj.dto.ActionForward;

@WebServlet(urlPatterns={"*.do"},
					  loadOnStartup = 1,  //1로 설정되어있기때문에 젤먼저 수행해라
					  initParams = {
							  @WebInitParam( // init(ServletConfig config) 에서 사용
									  name = "configFile", 
									  value = "/WEB-INF/commandAction.properties")
					  }
		)
public class boardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Action> actionMap = new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String configFile = config.getInitParameter("configFile");
		try(InputStream is = config.getServletContext().getResourceAsStream(configFile)){
			Properties props = new Properties();
			props.load(is);
			
			for(Entry<Object, Object> entry : props.entrySet()) {
				Class<?> cls;
				Action action = null;

				try {
					cls = Class.forName(entry.getValue()+"");
					action = (Action) cls.newInstance();		
				}catch (ClassNotFoundException e) {
					action = new NullAction();
					e.printStackTrace();
				}
				actionMap.put(entry.getKey()+"", action);
			}
//			for(Entry<String, Action> entry : actionMap.entrySet()) {
//				System.out.println(entry.getKey()+" : " +entry.getValue());
//			}
		} catch (IOException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getServletPath();

		Action action = actionMap.get(command);
		ActionForward forward = action.execute(request, response);
		
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				request.getRequestDispatcher(forward.getPath()).forward(request, response);
			}
		}
	}

}
