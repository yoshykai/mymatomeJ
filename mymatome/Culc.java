package mymatome;

public class Culc {
	/*Stringはo, o.o, o/oの3つ*/
	public static String culc(String a,String b,int c){
		int a1[],b1[],bunsu[];
		a1 = trans(a);
		b1 = trans(b);
		bunsu = new int[2];
		if(c==0){
			bunsu = add(a1,b1);
		}else if(c==1){
			bunsu = sub(a1,b1);
		}else if(c==2){
			bunsu = mul(a1,b1);
		}else if(c==3){
			bunsu = div(a1,b1);
		}

		return reduction(bunsu[1],bunsu[0]);
	}

	private static int[] add(int a[], int b[]){
		int c[] = new int[2];
		c[0] = a[0]*b[1]+a[1]*b[0];
		c[1] = a[1]*b[1];
		return c;
	}

	private static int[] sub(int a[], int b[]){
		int c[] = new int[2];
		c[0] = a[0]*b[1]-a[1]*b[0];
		c[1] = a[1]*b[1];
		return c;
	}

	private static int[] mul(int a[], int b[]){
		int c[] = new int[2];
		c[0] = a[0]*b[0];
		c[1] = a[1]*b[1];
		return c;
	}

	private static int[] div(int a[], int b[]){
		int c[] = new int[2];
		c[0] = a[0]*b[1];
		c[1] = a[1]*b[0];
		return c;
	}

	private static int[] trans(String a){
		int result[] = new int[2];
		if(a.indexOf("/")!=-1){
			String b[] = a.split("/");
			result[0] = Trans.stoi(b[0]);
			result[1] = Trans.stoi(b[1]);
		}else if(a.indexOf(".")!=-1){
			String b[] = a.split("\\.");
			result[0] = Trans.stoi(b[0] + b[1]);
			result[1] = (int)(Math.pow(10,b[1].length()));
		}else{
			result[0] = Trans.stoi(a);
			result[1] = 1;
		}
		return result;
	}

	private static String reduction(int fraction,int numerator){
		String sol = "";
		boolean fugouFlg = false;//trueならマイナス
		int keep=0;
		if(fraction==0){
			return "error";
		}
		if(fraction<0){
			fugouFlg = !fugouFlg;
			fraction *= -1;
		}
		if(numerator<0){
			fugouFlg = !fugouFlg;
			numerator *= -1;
		}
		keep = Mymath.gcd(fraction,numerator);
		fraction/=keep; numerator/=keep;
		if(fugouFlg){
			numerator*=-1;
		}
		if(fraction==1){
			sol = String.valueOf(numerator);
		}else{
			sol = String.valueOf(numerator+"/"+fraction);
		}
		return sol;
	}
}
