
public class CheckCollision {
	
	public static boolean checkDiamond(int Ppx, int Ppy, int Dpx, int Dpy) {
		
		boolean check = false;
		if((Ppx >= Dpx && Ppx + 30 <= Dpx + 50) && (Ppy + 100 == Dpy + 50)) {
			check = true;
		}
		return check;
	}
	
	public static boolean checkEnemy(int Ppx, int Ppy, int Epx, int Epy ) {
		boolean check = false;
		if((Ppx >= Epx && Ppx + 30 <= Epx + 30) && (Ppy == Epy) || (Ppx <= Epx + 30  && Ppx + 30 >= Epx) && (Ppy == Epy) ) {
			check = true;
		}
		return check;
	}

}
