package Notebook;

import java.util.ArrayList;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class Notebook {
	private ArrayList<String> notes=new ArrayList<>();
//	private int size;
	public void  add(String s)
	{
		notes.add(s);
//		size++;
	}
	public int getSize()
	{
		return notes.size();
	}
	public String getnote(int index)
	{
		return notes.get(index);
	}
	public  void removeNote(int index)
	{
		notes.remove(index);
	}
	public String[] list()
	{
	 String[] a=new String[notes.size()];
	 for(int i=0;i<notes.size();i++)
	 {
		 a[i]=notes.get(i);
	 }
	 return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Notebook nb=new Notebook();
		nb.add("first");
		nb.add("second");
		nb.add("thrid");
		System.out.println(nb.getSize());
		System.out.println(nb.getnote(0));
		System.out.print(nb.getnote(2));  //这里你刚刚是10，超过arraylist的范围了，懂了吗
		int index=1;
		nb.removeNote(index);
		System.out.println(nb.getSize());
		String[] a=nb.list();
		for (String s:a) {
		System.out.println(s);
		}
		
	}

}
