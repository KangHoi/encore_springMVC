package com.encore.spring.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.model.UploadDataVO;

@Controller
public class FileController {
	
	@RequestMapping("fileupload.do")
	public ModelAndView fileupload(HttpServletRequest request, UploadDataVO vo) throws Exception{
		//1. 업로드된 파일의 정보를 가지고 있는 MultipartFile을 하나 받아온다... vo에서
		MultipartFile[] mFiles = vo.getUploadFiles();
		System.out.println("mFiles ::" + mFiles);
		
		/*
		 * 2. 업로드된 파일이 있다면
		 *    파일의 사이즈
		 *    업로드한 파일의 이름
		 *    업로드한 파일의 파라미터명
		 */
//		if((mFile.isEmpty())!=true) {//업로드된 파일이 있다면
//			System.out.println("파일의 사이즈  :: " + mFile.getSize());
//			System.out.println("업로드된 파일명  :: " + mFile.getOriginalFilename());
//			System.out.println("파일의 파라미터명:: " + mFile.getName());
//		}
		
		for(MultipartFile mFile : mFiles) {
			System.out.println("파일의 사이즈  :: " + mFile.getSize());
			System.out.println("업로드된 파일명  :: " + mFile.getOriginalFilename());			
			System.out.println("파일의 파라미터명:: " + mFile.getName());
			
		}
		
		//3. 업로드한 파일을 지정한 경로에 copy해서 이동시킴... /upload/copy 해온 파일이 저장됨.
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root + "\\upload\\";
		
		List<String> uploadFiles = new ArrayList();
		//4. File 객체 생성... mFile.transferTo()
		for(MultipartFile mFile : mFiles) {
			if(mFile.getSize() >0) {
				uploadFiles.add(mFile.getOriginalFilename());
				File copyFile = new File(path + mFile.getOriginalFilename());
				mFile.transferTo(copyFile);
				System.out.println("path : " + path);
			}
		}
		
		
		return new ModelAndView("upload_result","uploadfiles", uploadFiles);

	}
		@RequestMapping("fileDown.do")
		public ModelAndView filedown(HttpServletRequest request,String filename)throws Exception{
			System.out.println("filename :: "+filename);
			String root = request.getSession().getServletContext().getRealPath("/");		
			String path = root+"\\upload\\";
			
			HashMap map = new HashMap();
			map.put("path", path);
			return new ModelAndView("downloadView",map);
		}
	}
