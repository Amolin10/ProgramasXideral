package com.cliente;

import java.util.*;

import com.interfaces.*;
import com.pojo.Empleado;

public class Principal1 {

	public static void main(String[] args) {

		List<Empleado> listaEmpleados = new ArrayList<>();
		listaEmpleados.add(new Empleado("Patrobas",28,45.67));
		listaEmpleados.add(new Empleado("Tercio",15,56.67));
		listaEmpleados.add(new Empleado("Andronico",19,40.50));
		listaEmpleados.add(new Empleado("Rolas",17,60.03));
		
		PredicadoEmpleado pe01 = new MayorEdadA();
		PredicadoEmpleado pe02 = new SueldoMayorA();
		PredicadoEmpleado pe03 = new nombreLetrasMayorA();
		
	}

}
