//Client App
package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorService;

@SpringBootApplication
public class BootProj3DataJpaApplication {

	public static void main(String[] args) {
		// Get IOC Container
		ApplicationContext ctx = SpringApplication.run(BootProj3DataJpaApplication.class, args);
		// Get Service class OBJ
		IDoctorService service = ctx.getBean("doctorService", IDoctorService.class);

		try {
			// Create the The Doctor class Obj
			Doctor doctor = new Doctor();
			doctor.setDocName("king");
			doctor.setSpecialization("MD-Cardio");
			doctor.setIncome(67000.0);

			// Invoke the Bussiness method
			String resultMsg = service.registerDoctor(doctor);
			System.out.println(resultMsg);
			System.out.println("pracice it");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Doctor doc1=new Doctor();
			doc1.setDocName("king");doc1.setIncome(87000.0);doc1.setSpecialization("Cardio");
			Doctor doc2=new Doctor();
			doc2.setDocName("raju");doc2.setIncome(84000.0);doc2.setSpecialization("Physician");
			Doctor doc3=new Doctor();
			doc3.setDocName("king");doc3.setIncome(36000.0);doc3.setSpecialization("ortho");
			
			String msg=service.registerGroupOfDoctors(List.of(doc1,doc2,doc3));
			//String msg=service.registerGroupOfDoctors(Arrays.asList(doc1,doc2,doc3));
			
			System.out.println(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//close the Container
		((ConfigurableApplicationContext) ctx).close();
     
	}

}
