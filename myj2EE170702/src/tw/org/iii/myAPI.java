package tw.org.iii;

public class myAPI {
	//header string as...
	//form-data; name="upload"; filename="C:\Users\Mac\Desktop\qwdqwd.txt"
	//return  qwdqwd.txt ..
	public static String getHeaderFileName(String header) {
		int start = header.indexOf("filename");
		String temp = header.substring(start + 10);
		String filename = temp.substring(0 , temp.lastIndexOf("\""));
		int s1 = filename.lastIndexOf("\\")+1;
		String sfile = null;
		if (s1>=0) {
			sfile = filename.substring(filename.lastIndexOf("\\")+1);
		}else {
			sfile = filename;
		}
		return sfile;
	}

}
