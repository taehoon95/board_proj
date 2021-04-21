package board_proj.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_proj.dto.ActionForward;

public class fileDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		///file_down.do?downFile=image.png
		
		String fileName = request.getParameter("downFile");
		 
		String savePath = "boardUpload";
		ServletContext context = request.getServletContext();
		String sDownloadPath = context.getRealPath(savePath);
		String sFilePath = sDownloadPath + "\\" + fileName;
		byte b[] = new byte[4096];
		FileInputStream in = null;
		try {
			in = new FileInputStream(sFilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String sMimeType = request.getSession().getServletContext().getMimeType(sFilePath);
		System.out.println("sMimeType >>> " + sMimeType);
		
		if(sMimeType == null) {
			sMimeType = "application/octet-stream";
		}	
		
		response.setContentType(sMimeType);
		
		String agent = request.getHeader("User-Agent");
		boolean ieBrowser = (agent.indexOf("MSIE") > -1) || (agent.indexOf("Trident") > -1);
		
		if(ieBrowser) {
			try {
				fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}else {
			try {
				fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		response.setHeader("Content-Disposition", "attachment; filename = "+fileName);
		
		ServletOutputStream out2 = null;
		try {
			out2 = response.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int numRead;
		 
		try {
			while((numRead = in.read(b, 0, b.length)) != -1) {
				out2.write(b, 0, numRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			out2.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			out2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	

}
