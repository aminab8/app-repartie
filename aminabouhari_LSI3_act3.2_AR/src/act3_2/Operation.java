package act3_2;

import java.io.Serializable;

public class Operation implements Serializable{
	 private int nb1,nb2,res;
	    private char op;
	    public Operation(){
	        this.nb1=nb1;
	        this.nb2=nb2;
	        this.op = op;
	    }
	    public int getNb1() {
	        return nb1;
	    }
	    public int getNb2() {
	        return nb2;
	    }
	    public char getOp() {
	        return op;
	    }
	    public int getRes() {
	        return res;
	    }
	    public void setRes(int res) {
	        this.res = res;
	    }

}
