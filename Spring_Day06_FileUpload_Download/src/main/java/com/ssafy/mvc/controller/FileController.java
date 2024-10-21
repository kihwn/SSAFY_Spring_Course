package com.ssafy.mvc.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
//@Component라고 해도 됨. 컨트롤러는 컴포넌트의 하위 어노테이션
@Controller
public class FileController {
	
	private ResourceLoader resourceLoader;
	
	@Autowired //가 없어도 생성자가 하나라 자동으로 주입되어있음.
	public FileController(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	
	
	
	@GetMapping("/singleFileForm")
	public String singleFileForm() {
		return "singleFileForm";
	}
	
	@PostMapping("/singleFileUpload") //파라미터를 갖고 오기 위해 @RequestParam 사용
	//파일이 여러 개 일 땐 MultipartFile[] 형식 사용하면 . MVC 패턴에서 컨트롤러에서 View로 보낼 데이터들을 Model에 담아서 보내게 됨.
	public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model) throws IllegalStateException, IOException {
		if (file!=null && file.getSize()>0) {
			String fileName = file.getOriginalFilename();
			
			//코드로 resources/static/img 폴더를 가지고 오자.
			//스프링에서 파일이나 클래스 등등 리소스를 로드할 때는 리소스 ResourceLoader 인터페이스를 이용해서 가져온다.
			Resource resource = resourceLoader.getResource("classpath:/static/img");
			
			file.transferTo(new File(resource.getFile(),fileName));
			//resource.getFile()을 통해 위에서 저장한 "classpath:/static/img"을 가져오게 됨. 
			//모델은 바구니같은 역할
			model.addAttribute("fileName",fileName);
		}
		return "result"; //데이터가 넘어 옴.
	}
	
	@GetMapping("/download")
	public String fileDownload(@RequestParam("fileName") String fileName, Model model) {
		model.addAttribute("fileName", fileName);
		return "fileDownloadView";
	}

	
	@GetMapping("/multiFileForm")
	public String multiFileForm() {
		return "multiFileForm";
	}
	
	
	
	@PostMapping("/multiFileUpload")
	public String multiFileUpload(@RequestParam("files") MultipartFile[] files, Model model)
			throws IllegalStateException, IOException {
		
		for(MultipartFile file : files) {
			System.out.println(file.getOriginalFilename());
		}
		
		
		
		return "result";
	}

}
