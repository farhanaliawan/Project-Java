public class Menu{
		String[][] menu = {
			{"Day","         Breakfast","         Lunch","                 Dinner"},
			{"Monday","    Alu Bhujia","     Daal Mash","         Chicken Biryani"},
			{"Tuesday","    Fry Egg","       Mix Vegetables","      Chicken Roast"},
			{"Wednesday","Channay","Daal Chawal","  Chicken Alu"},
			{"Thursday","   Omelete","    Daal Channa","      Beef Qeema"},
			{"Friday","        Alu Bhujia","         Channa Pulao","        Beef Nihari"},
			{"Saturday","     Fry Egg","       Channay","            Qabili Pulao"},
			{"Sunday","      Channay","      Lobia","              Alu Chicken"}
		};
	public String printMenu(){
		String s = "";
			for (int i = 0 ;i<menu.length ;i++ ) {
			for (int j = 0 ;j<menu[i].length ;j++ ) {
				s += String.format("%-20s",menu[i][j]);
			}
			s+= String.format("\n");
		}
		return s;
		}
}