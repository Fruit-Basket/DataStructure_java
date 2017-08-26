package fruitbasket.string;

public class  PatternMatch {
	
	private static final PatternMatch instance=new PatternMatch();
	private PatternMatch(){}
	
	public PatternMatch getInstance(){
		return instance;
	}
	
	/**
	 * BF模式匹配
	 * @param string 主串
	 * @param sub 模式
	 * @return 模式在主串第1次出现的位置
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
