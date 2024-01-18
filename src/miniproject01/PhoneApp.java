package miniproject01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		Reader fr = new FileReader("C:\\javaStudy\\미니프로젝트\\PhoneDB_원본 - 복사본.txt");
		BufferedReader br = new BufferedReader(fr);

		List<Phone> pList = new ArrayList<>();

		while (true) {
			String str = br.readLine();
			if (str == null) {
				break;
			}
			String[] info = str.split(",");
			String name = info[0];
			String hp = info[1];
			String company = info[2];

			Phone p = new Phone(name, hp, company);
			pList.add(p);

		}

		System.out.println("*********************************************");
		System.out.println("*          전화번호 관리 프로그램           *");
		System.out.println("*********************************************");
		System.out.println("");
		
		
	    while (true) {
		  
		  System.out.println("1.리스트  2.등록  3.삭제  4. 검색  5.종료");
		  System.out.println("------------------------------------------");
		  System.out.print(">메뉴번호:"); 
		  int no = sc.nextInt();
		  
		  switch (no) {
		  
		       case 1 : 
			  
			       System.out.println("<1.리스트>");
			       
			       for(int i=0; i<pList.size(); i++) {
			    	   System.out.print( (i+1) + "." + "   " );
				       pList.get(i).showInfo();
				   }
			       
			       System.out.println("");
			       break;
		  
		       case 2 :
		    	  
		    	   System.out.println("<2.등록>");
	               sc.nextLine(); 
	               System.out.print(">이름: ");
	               String name = sc.nextLine(); 
	               System.out.print(">휴대전화: ");
	               String hp = sc.nextLine();
	               System.out.print(">회사번호: "); 
	               String company = sc.nextLine();
		 
		           pList.add(new Phone(name,hp,company));
		           System.out.println("[등록되었습니다.]"); 
		           break;
		  
		        case 3 :
		        	
		        	System.out.println("<3.삭제>");
		        	sc.nextLine(); 
		        	System.out.print(">번호 : "); 
		        	int num = sc.nextInt(); 
		        	pList.remove(num); 
		        	System.out.println("[삭제되었습니다.]");
		        	break;
		        
		        case 4 :
		        	
		        	System.out.println("<4.검색>");
		        	sc.nextLine();
		        	System.out.print("이름: ");
		        	CharSequence ch = sc.nextLine();
		        	
		        	for(int i=0; i<pList.size(); i++) {
		        		if(pList.get(i).getName().contains(ch)) {
		        			
		        			pList.get(i).showInfo();
		        		} 
		        	}
		        	
		        	break;
		        	
		        case 5 :
		        	
		        	break;
		        	
		        default:
		        	
		        	System.out.println("[다시 입력해주세요.]");
		        	break;
		        	
		  }
		  
		  if (no == 5) {
			  break;
		  }
		  
	    }
	    
	    System.out.println("");
		System.out.println("******************************************");
		System.out.println("*               감사합니다               *");
		System.out.println("******************************************");
		  
		br.close(); 
		sc.close();
		 

	}

}
