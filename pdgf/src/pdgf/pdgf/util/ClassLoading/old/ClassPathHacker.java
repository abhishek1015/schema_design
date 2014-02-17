/*******************************************************************************
 * Copyright (c) 2011, Chair of Distributed Information Systems, University of Passau. 
 * All rights reserved. 
 * 
 * Redistribution and use in source and binary forms, with or without modification, 
 * are permitted provided that the following conditions are met: 
 * 
 * 1. Redistributions of source code must retain the above copyright notice, 
 *     this list of conditions and the following disclaimer. 
 * 
 * 2. Redistributions in binary form must reproduce the above copyright 
 *     notice, this list of conditions and the following disclaimer in the 
 *     documentation and/or other materials provided with the distribution. 
 * 
 * 3. Neither the name of the University of Passau nor the names of its 
 *     contributors may be used to endorse or promote products derived 
 *     from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE REGENTS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED 
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A 
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE REGENTS OR 
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY 
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT 
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE 
 * USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH 
 * DAMAGE.
 ******************************************************************************/
package pdgf.util.ClassLoading.old;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 
 * @author Michael Frank
 * @version 1.0 08.06.2010
 * 
 */
public class ClassPathHacker {

	private static final Class[] params = new Class[] { URL.class };

	public static void addURL(URL url) {
		URLClassLoader loader = (URLClassLoader) ClassLoader
				.getSystemClassLoader();
		try {
			Method method = URLClassLoader.class.getDeclaredMethod("addURL",
					params);
			method.setAccessible(true);
			method.invoke(loader, new Object[] { url });

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addFile(String s) {
		File f = new File(s);
		addFile(f);
	}

	public static void addFile(File f) {
		try {
			addURL(f.toURI().toURL());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
