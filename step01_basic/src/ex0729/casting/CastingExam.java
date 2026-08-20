package ex0729.casting;

class CastingExam{
	public static void main(String []args){
		byte b1;
		byte b2,b3; 
		int i1=7;
		System.out.println("int i1="+i1); // int i1=7

		b1=(byte)i1 ; // 4byte를 1byte에 담을 수 없다. 캐스팅 필요
		System.out.println("byte b1="+b1); // byte b1=7

		b2=20;
		System.out.println("byte b2="+b2); // byte b2=20
		
	   	b3=(byte)(b2+b1); // 연산시 자동으로 int 타입으로 변환하므로 byte로 캐스팅해서 연산
		System.out.println("byte b3="+b3); // byte b3=27
		
		long lo=56897L;
		System.out.println("long lo="+lo); // long lo=56897

		// int i4=(int)lo+i1; 
		int i4=(int)(lo+i1); 
		System.out.println("int i4="+i4); // int i4=56904
		
		boolean boo;
		boo=false; // boolean 타입에는 true나 false만 올 수 있다.
		System.out.println("boolean boo="+boo); //  false

		double d=4.67e-3;
		System.out.println("double d="+d); // double d=0.00467

		float f1=lo; // Promotion (long < float)
		System.out.println("float f1="+f1); // float f1=56897.0
				
		
	    float f2=(float)d; // double을 float로 casting
		System.out.println("float f2="+f2); // float f2=0.00467

		char c1,c2, c3;
		c1='\u0167';
		System.out.println("char c1="+c1); // char c1=ŧ

		b2=(byte)c1; // char 타입을 byte로 casting
		System.out.println("byte b2="+b2); // byte b2=103
		
		c2='A';
		System.out.println("char c2="+c2); // char c2=A
		
		
		c3=(char)(c2+2); // 연산시 자동으로 int 타입으로 변환하므로 char로 캐스팅해서 연산
		System.out.println("char c3="+c3); // char c3=C
		
		
	}

}