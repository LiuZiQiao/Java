package dbutil;

/**
* @author 作者  小小刘
* @version 创建时间：2018年11月27日 下午1:27:42
* 类说明
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LogInfo {
	private static String filepath = "F:";
	private static Calendar c = Calendar.getInstance();
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 记录日志文件
	 * 
	 * @param file
	 * @param username
	 * @param ip
	 * @param dowhat
	 */
	public static void saveLog(File file, String username, String ip, String dowhat) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
			bw.newLine();
			bw.write("用户 " + username + ",ip为  " + ip + ",进行了 " + dowhat + " 操作\n");
			bw.flush();
		} catch (FileNotFoundException e) {
			System.out.println("文件未找到");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != bw) {
				try {
					bw.close();
				} catch (IOException e) {
					System.out.println("流操作异常");
				}
			}
		}
	}

	/**
	 * 根据时间创建日志文件
	 * 
	 * @return
	 */
	public static File createFile() {
		// 每天创建一个日志文件,名称为"2018-11-25.txt"
		File file = null;
		try {
			file = new File(filepath + sdf.format(c.getTime()) + ".txt");
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			System.out.println("路径不存在");
		}
		return file;
	}

	// public static void main(String[] args) {
	// File file = createFile();
	// saveLog(file, "localhost", "127.0.0.1", "更改密码");
	// }
}