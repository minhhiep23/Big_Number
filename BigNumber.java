public class BigNumber {

    public String standardize(String value){ // Chuan 1 so khong co 0000 o dau
      	StringBuffer s = new StringBuffer(value);
    		for (;s.length()>1 && s.charAt(0)=='0' ;){
    			s.deleteCharAt(0);
    		}
    		return s.toString();
    }
    	
	public String addition(String a,String b){
		a=standardize(a);
		b=standardize(b);
		StringBuffer number3,number1,number2;
		number3 = new StringBuffer("");
		if (a.length()>b.length()){ // de mac dinh do dai number1 >= do dai number2
			number1 = new StringBuffer(a);
			number2 = new StringBuffer(b);
		} else {
			number1 = new StringBuffer(b);
			number2 = new StringBuffer(a);
		}
		
		number1=number1.reverse();
		number2=number2.reverse();
		int carry=0;//bien nho
		for (int i=0;i<number2.length();i++){
            int temp=number2.charAt(i)+number1.charAt(i)+carry-2*'0';
            carry = temp/10;
            number3.append(temp%10);
		}
        for (int i=number2.length();i<number1.length();i++){
            int temp=number1.charAt(i)+carry-'0';
            carry = temp/10;
            number3.append(temp%10);
        }
        if (carry!=0) number3.append(carry);
		number3=number3.reverse();
		return standardize(number3.toString());
	}
	
	public String subtraction(String a,String b){
		a=standardize(a);
		b=standardize(b);
		if (a.length()<b.length()) return "<0";
		StringBuffer number3,number1,number2;
		number3 = new StringBuffer("");
		number1 = new StringBuffer(a);
		number2 = new StringBuffer(b);
		number1=number1.reverse();
		number2=number2.reverse();
		int carry=0;//bien nho
		for (int i=0;i<number2.length();i++){
        	int temp=10+number1.charAt(i)-number2.charAt(i)-carry;
        	carry =1- temp/10;
        	number3.append(temp%10);
    	}
   		for (int i=number2.length();i<number1.length();i++){
            int temp=10+number1.charAt(i)-carry-'0';
            carry =1- temp/10;
            number3.append(temp%10);
        }
		number3=number3.reverse();
		return standardize(number3.toString());
	}
	
	public String multiplication(String a,String b){
		a=standardize(a);
		b=standardize(b);
		StringBuffer number3, number1, number2, numberTmp;
		number1 = new StringBuffer(a);
		number2 = new StringBuffer(b);
		number3 = new StringBuffer("0");
		number1=number1.reverse();
		number2=number2.reverse();
		
		
		for (int j=0;j<number2.length();j++){
        	numberTmp= new StringBuffer("");;
        	for (int k=0;k<j;k++) 
        			numberTmp.append("0");
        	int carry=0;
        	if (number2.charAt(j)-'0'==0)
        		continue;
        	for (int i=0;i<number1.length();i++){
            	int temp =((number1.charAt(i)-'0') * (number2.charAt(j)-'0') + carry);
            	carry=temp/10;
            	numberTmp.append(temp%10);
        	}
        	if (carry!=0) numberTmp.append(carry);
        	numberTmp.reverse();
        	number3.reverse();
        	number3 = new StringBuffer(addition(number3.toString(),numberTmp.toString()));
        	number3.reverse();
    	}
		number3=number3.reverse();
		return standardize(number3.toString());
	}
	
	public String div(String a,String b){
		a=standardize(a);
		b=standardize(b);
		if (b.equals("0")) 
			return "#";
		if (b.equals("1")) 
			return a;
		if (b.length()>a.length()) 
			return "0";
		StringBuffer number3, number1, number2;
		number1 = new StringBuffer(a);
		number2 = new StringBuffer(b);
		number3 = new StringBuffer("0");
		number1=number1.reverse();
		number2=number2.reverse();
		
		if (number1.length()==number2.length()){
			for (;subtraction(number1.reverse().toString(),
								multiplication(number2.reverse().toString(),
												number3.reverse().toString()
												)
								)!="<0";
				){
				number2.reverse();
				number3.reverse();
				number3=new StringBuffer(addition(number3.reverse().toString(),"1"));
				number3=number3.reverse();
			} 
        	number3=new StringBuffer(subtraction(number3.reverse().toString(),"1"));
        	
        	number3=number3.reverse();
			return number3.toString();
		}
		
		number3=number3.reverse();
		return number3.toString();
	}
	
	
    public static void main(String[] args) {
    	BigNumber a = new BigNumber();

    	System.out.println(a.div("10","7"));
    }
}
