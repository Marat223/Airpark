package org.mustafin.airpark.annotation;

import java.lang.annotation.Annotation;

import org.mustafin.airpark.company.CompanyParametrized;
import org.mustafin.airpark.item.vehicle.AbstracVehicle;

public class CompanyProxyCreator {

    private final String OLD_CLASS_ANNOTATION = "@org.mustafin.airpark.annotation.OldClass";
    private final String NEW_CLASS_ANNOTATION = "@org.mustafin.airpark.annotation.NewClass";

    public CompanyParametrized findMatchedId(String fullQualifiedNameOrginalClass, String fullQualifiedNameProxyClass) {
	CompanyParametrized companyParametrized = new CompanyParametrized<AbstracVehicle>();
	try {
	    for (Annotation originalClassAnnotation : CompanyProxyCreator.class.getClassLoader()
		    .loadClass(fullQualifiedNameOrginalClass).getAnnotations()) {
		if (originalClassAnnotation.toString().startsWith(OLD_CLASS_ANNOTATION)) {
		    for (Annotation proxyClassAnnotation : CompanyProxyCreator.class.getClassLoader()
			    .loadClass(fullQualifiedNameProxyClass).getAnnotations()) {
			if (proxyClassAnnotation.toString().startsWith(NEW_CLASS_ANNOTATION)) {
			    if (proxyClassAnnotation.toString().substring(OLD_CLASS_ANNOTATION.length()).contentEquals(
				    originalClassAnnotation.toString().substring(NEW_CLASS_ANNOTATION.length()))) {
				System.out.println(">matched");
			    }

			}
		    }
		}
	    }
	} catch (SecurityException | ClassNotFoundException e) {
	    e.printStackTrace();
	}
	return companyParametrized;
    }

}
