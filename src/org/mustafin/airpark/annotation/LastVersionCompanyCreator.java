package org.mustafin.airpark.annotation;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class LastVersionCompanyCreator<T> {

    final String OLD_CLASS_ANNOTATION = "@org.mustafin.airpark.annotation.OldClass";
    final String NEW_CLASS_ANNOTATION = "@org.mustafin.airpark.annotation.NewClass";

    public Object createInstance(T actualClassEntity) {
	Class actualClass = actualClassEntity.getClass();
	for (Annotation actualClassAnnotation : actualClass.getAnnotations()) {
	    String actualClassAnnotationString = actualClassAnnotation.toString();
	    if (actualClassAnnotationString.startsWith(OLD_CLASS_ANNOTATION)) {
		for (Class proxyClass : findAllClassesInProject()) {
		    if (actualClass == proxyClass) {
			continue;
		    }
		    for (Annotation proxyClassAnnotation : proxyClass.getAnnotations()) {
			String proxyClassAnnotationString = proxyClassAnnotation.toString();
			if (proxyClassAnnotationString.startsWith(NEW_CLASS_ANNOTATION)
				&& proxyClassAnnotationString.substring(OLD_CLASS_ANNOTATION.length())
					.equals(actualClassAnnotationString.substring(NEW_CLASS_ANNOTATION.length()))) {
			    try {
				return proxyClass.newInstance();
			    } catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			    }
			}
		    }
		}
	    }
	}
	return actualClassEntity;
    }

    private Class[] findAllClassesInProject() {
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
		classes.addAll(findClassesInDirectory(directory, packageName));
	    }
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	return classes.toArray(new Class[classes.size()]);
    }

    private List<Class> findClassesInDirectory(File directory, String packageName) throws ClassNotFoundException {
	List<Class> classes = new ArrayList<>();
	if (!directory.exists()) {
	    return classes;
	}
	File[] files = directory.listFiles();
	for (File file : files) {
	    if (file.isDirectory()) {
		classes.addAll(findClassesInDirectory(file, packageName + "." + file.getName()));
	    } else if (file.getName().endsWith(".class")) {
		classes.add(
			Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
	    }
	}
	return classes;
    }
}
