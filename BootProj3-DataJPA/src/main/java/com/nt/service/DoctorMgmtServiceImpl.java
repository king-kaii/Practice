package com.nt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repo.IDoctorRepo;

@Service("doctorService")
public class DoctorMgmtServiceImpl implements IDoctorService {
	@Autowired
	private IDoctorRepo doctorRepo;

	@Override
	public String registerDoctor(Doctor doctor) {
		System.out.println("Repo proxy Class is::" + doctorRepo.getClass() + "....."
				+ Arrays.toString(doctorRepo.getClass().getInterfaces()));
		System.out.println("doc Id(before Save::" + doctor.getDocId());
		Doctor doc = doctorRepo.save(doctor);
		return "Doctor obj Is Saved with Id value::" + doc.getDocId();
	}

//	@Override
//	public String registerGroupOfDoctors(Iterable<Doctor> doctors) {
//		
//		if(doctors!=null) {
//			Iterable<Doctor> saveDoctors=doctorRepo.saveAll(doctors);
//			int size=((Collection)saveDoctors).size();
//			List<Integer> ids=(List<Integer>)((Collection)saveDoctors).stream().map(d->((Doctor)d).getDocId()).collect(Collectors.toList());
//			return size+"no. of doctors are saved with id values:"+ids.toString();
//		}
//		else
//			throw new IllegalArgumentException("invalid doctors info");
//		
//	}     (or)

	@Override
	public String registerGroupOfDoctors(Iterable<Doctor> doctors) {
		if (doctors != null) {
			System.out.println(doctorRepo.getClass()+"....."+Arrays.toString(doctorRepo.getClass().getDeclaredMethods()));
			Iterable<Doctor> saveDoctors = doctorRepo.saveAll(doctors);
			int size = ((Collection) saveDoctors).size();
			List<Integer> ids = new ArrayList();
			 saveDoctors.forEach(d->{ids.add(d.getDocId());
			 });
			return size + "no. of doctors are saved with id values:" + ids.toString();
		} else
			throw new IllegalArgumentException("invalid doctors info");
		
	}

}
