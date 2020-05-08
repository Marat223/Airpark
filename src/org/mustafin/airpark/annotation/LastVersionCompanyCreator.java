package org.mustafin.airpark.annotation;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.mustafin.airpark.company.CompanyParametrized;
import org.mustafin.airpark.item.vehicle.AbstracVehicle;

public class LastVersionCompanyCreator<T> {

    final String OLD_CLASS_ANNOTATION = "@org.mustafin.airpark.annotation.OldClass";
    final String NEW_CLASS_ANNOTATION = "@org.mustafin.airpark.annotation.NewClass";

    public void createInstance1(T t) {
	Class actualClass = t.getClass();
	{
	    for (Annotation actualClassAnnotation : actualClass.getAnnotations()) {
		if (actualClassAnnotation.toString().startsWith(OLD_CLASS_ANNOTATION)) {
		    for (Class clazz : getClasses()) {
			System.out.println(clazz);
		    }
		}
	    }
	}
    }

    public CompanyParametrized createInstance(String fullQualifiedNameOrginalClass,
	    String fullQualifiedNameProxyClass) {
	CompanyParametrized companyParametrized = new CompanyParametrized<AbstracVehicle>();
	try {
	    for (Annotation originalClassAnnotation : LastVersionCompanyCreator.class.getClassLoader()
		    .loadClass(fullQualifiedNameOrginalClass).getAnnotations()) {
		if (originalClassAnnotation.toString().startsWith(OLD_CLASS_ANNOTATION)) {
		    for (Annotation proxyClassAnnotation : LastVersionCompanyCreator.class.getClassLoader()
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

    private static Class[] getClasses() {
	ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	String packageName = "org.mustafin.airpark";
	String path = packageName.replace('.', '/');
	Enumeration<URL> resources = null;
	try {
	    resources = classLoader.getResources(path);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	List<File> dirs = new ArrayList<>();
	while (null != resources && resources.hasMoreElements()) {
	    URL resource = resources.nextElement();
	    dirs.add(new File(resource.getFile()));
	}
	ArrayList<Class> classes = new ArrayList<>();
	try {
	    for (File directory : dirs) {
		classes.addAll(findClasses(directory, packageName));
	    }
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	return classes.toArray(new Class[classes.size()]);
    }

    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
	List<Class> classes = new ArrayList<>();
	if (!directory.exists()) {
	    return classes;
	}
	File[] files = directory.listFiles();
	for (File file : files) {
	    if (file.isDirectory()) {
		classes.addAll(findClasses(file, packageName + "." + file.getName()));
	    } else if (file.getName().endsWith(".class")) {
		classes.add(
			Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
	    }
	}
	return classes;
    }
}
