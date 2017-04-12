public class CopyOfMovie{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animation first = new Animation(1000, 500);


		first.setBackgroundImage("startscreen.png");
		first.frameFinished();

		char s = IO.readChar();

		if(s!='s'){
			System.exit(1);
		}

		Sprite sp1 = new Sprite("sprite1t2.png");
		sp1.setPosition(999,0);
		sp1.setSize(300, 150);
		Sprite sp2 = new Sprite("g3457.png");
		sp2.setSize(100,200);
		sp2.setPosition(0,0);

		Sprite sp3 = new Sprite("tri.png");
		sp3.setSize(400,200);
		sp3.setPosition(650,0);

		Sprite sp4 = new Sprite("shot.png");
		sp4.setSize(2, 1);

		Sprite sp5 = new Sprite("trex.png");

		sp5.setPosition(999, -50);
		sp5.setSize(600, 300);

		first.setFrameRate(1000);

		first.setBackgroundImage("background.png");
		first.addSprite(sp1);
		first.addSprite(sp2);


		first.frameFinished();
		sp4.setSize(50, 15);

		
		int y=0;
		int x=999;
		int z=0;
		double chance = Math.random();
		char f = 'f';
		first.addSprite(sp4);
		System.out.println("Type f to fire ");
		char userInput= IO.readChar();
		if(userInput!='f'){
			chance=0.0;
		}
		int doOver=1;
		while(y<1860){

			sp1.setPosition(x,0);
			sp2.setPosition(0,0);
			y++;
			x--;
			z++;
			if(userInput==f){
				sp4.setPosition(z+50, 80);
			}

			if(z>x){
				
				first.removeSprite(sp4);
				if(chance>0.2){
					first.removeSprite(sp1);
					break;
				}
			}
			if(x==0){
				first.removeSprite(sp1);
				first.removeSprite(sp2);
				if(doOver!=0){
					first.setBackgroundImage("Gameover.png");
				}else{
					first.setBackgroundImage("gameover1.png");
				}
				first.frameFinished();
				char t = IO.readChar();
				if(t=='t'&&doOver!=0){
					first.frameFinished();
					doOver--;
					y=0;
					x=999;
					z=0;
					first.setBackgroundImage("background.png");
					first.addSprite(sp1);
					first.addSprite(sp2);
					sp1.setPosition(750,0);
					sp2.setPosition(0,0);

					first.addSprite(sp4);
					first.frameFinished();

					System.out.println("Type f to fire ");

					userInput= IO.readChar();
					chance = Math.random();
				}else{
					//System.exit(1);
					first.setBackgroundImage("gameover1.png");
					first.frameFinished();
				}
				first.frameFinished();
			}
			first.frameFinished();
		}
		//first.removeSprite(sp1);

		//first.removeSprite(sp4);
		first.frameFinished();
		x=0;
		while(x<1000){
			sp2.setPosition(x, 0);
			x++;
			first.frameFinished();
		}



		sp2.setSize(100,200);
		sp2.setPosition(0,0);
		sp3.setSize(400,200);
		sp3.setPosition(650,0);

		first.addSprite(sp3);
		first.frameFinished();
		first.addSprite(sp4);
		System.out.println("Type f to fire ");
		userInput= IO.readChar();
	
		y=0;
		x=650;
		z=0;
		chance = Math.random();
		if(userInput!='f'){
			chance = 0.0;
		}
		doOver=1;
		while(y<1860){
			sp3.setPosition(x,0);
			sp2.setPosition(0,0);
			y++;
			x--;
			z++;
			if(userInput==f){
				sp4.setPosition(z+50, 80);
			}

			if(z>x){
				
				first.removeSprite(sp4);
				if(chance>0.2){
					first.removeSprite(sp3);
					break;
				}
				first.frameFinished();
			}
			if(x==0){
				first.removeSprite(sp3);
				first.removeSprite(sp2);
				if(doOver!=0){
					first.setBackgroundImage("Gameover.png");
				}else{
					first.setBackgroundImage("gameover1.png");
				}
				first.frameFinished();
				char t = IO.readChar();
				if(t=='t'&&doOver!=0){
					first.frameFinished();
					doOver--;
					y=0;
					x=999;
					z=0;
					first.setBackgroundImage("background.png");
					first.addSprite(sp3);
					first.addSprite(sp2);
					sp3.setPosition(650,0);
					sp2.setPosition(0,0);

					first.addSprite(sp4);
					first.frameFinished();

					System.out.println("Type f to fire ");

					userInput= IO.readChar();
					chance = Math.random();
					if(userInput!='f'){
						chance=0.0;
					}
					first.frameFinished();
				}else{
					//System.exit(1);
					first.setBackgroundImage("gameover1.png");
					first.frameFinished();
				}
				first.frameFinished();
			}
			first.frameFinished();
		}
		
		first.frameFinished();
		x=0;
		while(x<1000){
			sp2.setPosition(x, 0);
			x++;
			first.frameFinished();
		}


		first.setBackgroundImage("endstage.png");
		sp2.setSize(100,200);
		sp2.setPosition(0,0);
		sp5.setSize(400,200);
		sp5.setPosition(999,-25);

		first.addSprite(sp5);
		first.frameFinished();
		first.addSprite(sp4);
		System.out.println("Type f to fire ");
		userInput= IO.readChar();
	
		y=0;
		x=999;
		z=0;
		
		first.frameFinished();
		
		while(y<1860){

			sp5.setPosition(x,-25);
			sp2.setPosition(0,0);
			y++;
			x--;
			z++;
			if(userInput==f){
				sp4.setPosition(z+50, 80);
			}

			if(z>x){
				
				first.removeSprite(sp4);
				if(chance>0.2){
					first.removeSprite(sp5);
					break;
				}
			}
			if(x==0){
				first.removeSprite(sp5);
				first.removeSprite(sp2);
				if(doOver!=0){
					first.setBackgroundImage("Gameover.png");
				}else{
					first.setBackgroundImage("gameover1.png");
				}
				first.frameFinished();
				char t = IO.readChar();
				if(t=='t'&&doOver!=0){
					first.frameFinished();
					doOver--;
					y=0;
					x=999;
					z=0;
					first.setBackgroundImage("background.png");
					first.addSprite(sp5);
					first.addSprite(sp2);
					sp1.setPosition(750,0);
					sp2.setPosition(0,0);

					first.addSprite(sp4);
					first.frameFinished();

					System.out.println("Type f to fire ");

					userInput= IO.readChar();
					chance = Math.random();
				}else{
					//System.exit(1);
					first.setBackgroundImage("gameover1.png");
					first.frameFinished();
				}
				first.frameFinished();
			}
			first.frameFinished();
		}
		x=0;
		while(x<1000){
			sp2.setPosition(x, 0);
			x++;
			first.frameFinished();
		}
		first.frameFinished();
		first.removeSprite(sp2);
		first.setBackgroundImage("winscreen.png");
		first.frameFinished();
	}
}

