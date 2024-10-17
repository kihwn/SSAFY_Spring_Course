package com.ssafy.mvc.view;

import java.io.File;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component //Component를 활용하여 빈으로 넣으면 클래스의 맨 앞 글자가 소문자로 바뀌어서 bean으로 등록됨
public class FileDownloadView extends AbstractView {
	//어디에 있는 데이터를 가져올 건지를 알아야 하기 때문에 ResourceLoader 필요. 
	//스프링에서 파일이나 클래스 등등 리소스를 로드할 때는 리소스 ResourceLoader 인터페이스를 이용해서 가져온다.
	private ResourceLoader resourceLoader;
	
	@Autowired //가 없어도 생성자가 하나라 자동으로 주입되어있음.
	public FileDownloadView(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String fileName =(String) model.get("fileName"); //원래 model은 Object 형식이기 때문에 String으로 변경
		Resource resource = resourceLoader.getResource("classpath:/static/img");
		File file = new File(resource.getFile(),fileName);
		
		////여기까지 사전 준비////
		fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1"); //혹시 여러 언어 중에 utf-8로 인코딩 안되는 게 있을까봐 ISO-8859방식도 덧붙여줌.
		//약속처럼 쓰는 것
		response.setHeader("Content-Disposition", "attachment; fileName=\""+fileName+"\";");
	}
	
	

}
