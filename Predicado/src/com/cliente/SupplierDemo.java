package com.cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.pojo.Empleado;

public class SupplierDemo {

	public static void main(String[] args) {

		Supplier<Empleado> emp = () -> new Empleado("Andronico",19,40.50); 
        Empleado empLambda = emp.get();
        System.out.println(empLambda);
		
        Supplier<String> nombreEmp = () -> new Empleado("Andronico",19,40.50).getNombre(); 
        String nombreEmpleado = nombreEmp.get();
        System.out.println(nombreEmpleado);
        
        Supplier<Double> random = () -> Math.random();
        System.out.println(random.get());
        
        //Con un bloque de código
        Supplier<List<String>> s1 = () -> {
        	List<String> listTmp = new ArrayList<>();
        	listTmp.add("Aguila");
        	listTmp.add("Perro");
        	listTmp.add("Oso");
        	
        	return listTmp;
        };
        
	}
}
