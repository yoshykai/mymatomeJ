package mymatome;

public class Matrix {
	private double m[][];
	Matrix(int h,int w){
		m = new double[h][w];
	}
	Matrix(double d[][]){
		m = d;
	}

	public void set(int i,int j,double d){
		m[i][j] = d;
	}
	public double get(int i,int j){
		return m[i][j];
	}

	public int height(){
		return m.length;
	}

	public int width(){
		return m[0].length;
	}

	public String msg(){
		String str = "";
		for(int i=0;i<height();i++){
			str += "(";
			for(int j=0;j<width();j++){
				str += m[i][j]+",";
			}
			str += ")\n";
		}
		return str;
	}

	public Matrix copy(){
		Matrix c = new Matrix(height(),width());
		for(int i=0;i<height();i++){
			for(int j=0;j<width();j++){
				c.set(i, j, get(i,j));
			}
		}
		return c;
	}

	public double det(){
		double result = 0;
		if(width()!=height()){return 0;}
		if(width()==1){
			return get(0, 0);
		}else{
			for(int i=0;i<width();i++){
				Matrix b = new Matrix(height()-1,width()-1);
				int h=1;
				for(int j=0;j<b.width();j++){
					int num = 0;
					for(int k=0;k<b.width();k++){
						if(k==i){
							num++;
						}
						b.set( j, k, get(j+1,num));
						num++;
					}
				}
				if(i%2==1){
					h *= -1;
				}

				result += h*get(0,i)*b.det();
			}
		}
		return result;
	}

	public void exchenge(int i,int j){
		double b;
		for(int s=0;s<width();s++){
			b = get(i, s);
			set(i, s, get(j, s));
			set(j, s ,b);
		}
	}

	public static Matrix sum(Matrix a,Matrix b){
		Matrix c = new Matrix(a.height(),a.width());
		for(int i=0;i<a.height();i++){
			for(int j=0;j<a.width();j++){
				c.set(i, j, a.get(i, j)+b.get(i, j));
			}
		}
		return c;
	}

	public static Matrix multi(Matrix a,Matrix b){
		Matrix c = new Matrix(a.height(),a.width());
		for(int i=0;i<a.height();i++){
			for(int j=0;j<b.width();j++){
				double sum = 0;
				for(int k=0;k<a.width();k++){
					sum += a.get(i, k)+b.get(k, j);
				}
				c.set(i, j, sum);
			}
		}
		return c;
	}

	public static Matrix kaidan(Matrix a){
		Matrix c = a.copy();
		int gyou = 0; //行
		int gyouk = 0; //今の行
		for(int retu=0;retu<c.width()&&gyou<c.height();){
			//左端を1にする
			if(c.get(gyouk,retu)==0){
				gyouk++;
				if(gyouk>=c.height()){
					gyouk=gyou;
					retu++;
				}
				continue;
			}else{
				if(gyou==gyouk){
					if(!(c.get(gyouk,retu)==1)){
						for(int i=1;i<c.width()-retu;i++){
							c.set(gyou,retu+i,c.get(gyou,retu+i)/c.get(gyou,retu));
						}
						c.set(gyou,retu,1);
					}
				}else{
					c.exchenge(gyou,gyouk);
					gyouk=gyou;
					continue;
				}
			}

			//1のところを0にする
			for(int i=0;i<c.height();i++){
				if(!(i==gyou)){
					double b = c.get(i,retu);//掛け算
					for(int j=0;j<c.width();j++){
						double e = c.get(gyou,j)*b;
						c.set(i,j,c.get(i, j)-e);
					}
				}
			}
			gyou++;
			gyouk=gyou;
			retu++;
		}
		return c;
	}

	public static void exchenge(Matrix a,int i,int j){
		double b;
		for(int s=0;s<a.width();s++){
			b = a.get(i, s);
			a.set(i, s, a.get(j, s));
			a.set(j, s ,b);
		}
	}
}
