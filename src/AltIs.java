
public class AltIs {
	int sure;
	int makine;
	int baslangic_zamani=-1;
	AltIs is_icin_oncesi;
	AltIs is_icin_sonrasi;
	AltIs makine_icin_oncesi;
	AltIs makine_icin_sonrasi;
	Is parent;
	public AltIs(Is parent,int makine,int sure){
		this.makine = makine;
		this.sure = sure;
		this.parent = parent; 
	}
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("AltIs[makine="+makine+", süre="+sure+", baslangic_zamani="+baslangic_zamani+", parent="+parent.is_no+"]");
		return buf.toString();
	}
}
