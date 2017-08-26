package fruitbasket.string;

public class  PatternMatch {
	
	private static final PatternMatch instance=new PatternMatch();
	private PatternMatch(){}
	
	public PatternMatch getInstance(){
		return instance;
	}
	
	/**
	 * BFģʽƥ��
	 * @param string ����
	 * @param sub ģʽ
	 * @return ģʽ��������1�γ��ֵ�λ��
	 */
	public static int BF(char[] string,char[] sub){
		if(string!=null
				&&string.length>0
				&&sub!=null
				&&sub.length>0){
			
			int i=0,j=0;
			while(i<string.length
					&&j<sub.length){
				if(string[i]==sub[j]){
                    i++;
                    j++;
                }
                else{
                    i=i-j+1;
                    j=0;
                }
			}
			
			if(j>=sub.length){
				return i-sub.length;
			}
			else{
				return -1;
			}
		}
		else{
			return -1;
		}
	}
}
