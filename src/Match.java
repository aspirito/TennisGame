import java.util.Random;


public class Match {
	private Player giocatore1;
	private Player giocatore2;
	private boolean finished;
	
	public Match(){
		giocatore1 = new Player("giocatore1");
		giocatore2 = new Player("giocatore2");
		finished=false;
		System.out.println("Initial score: love - love ");
	}
	
	public Match(String nomeGiocatore1, String nomeGiocatore2){
		giocatore1 = new Player(nomeGiocatore1);
		giocatore2 = new Player(nomeGiocatore2);
		finished=false;
		System.out.println("Initial score: love - love ");
	}
	
	public Match(Player giocatore1, Player giocatore2){
		this.giocatore1 = giocatore1;
		this.giocatore2 = giocatore2;
		finished=false;
		System.out.println("Initial score: love - love ");
	}
	
	public String toString(){
		return "Match score : " + giocatore1.getNome() + ":" + giocatore1.getPunteggio() + " --- " + giocatore2.getNome() + ":" + giocatore2.getPunteggio();
	}
	
	public Random creaGeneratore(){
		return new Random(System.nanoTime());
	}
	
	public void randomScore(){
		if(creaGeneratore().nextInt()%2 == 1){
			giocatore1.scores();
			if(giocatore1.getPunteggio() == 3 && giocatore2.getPunteggio() == 3){
				System.out.println(giocatore1.getNome() + " scores > score : deuce");
				//funzione di pareggio
				while(finished==false){
					randomScoreOltranza();
				}
			}
			else if(giocatore1.getPunteggio() == 4){
				System.out.println(giocatore1.getNome() + " scores > score :" + giocatore1.getNome() + " wins.");
				finished = true;
			}
			else
				System.out.println(giocatore1.getNome() + " scores > score :" + giocatore1.getPunteggio() + " - " + giocatore2.getPunteggio());
		}
		else{
			giocatore2.scores();
			if(giocatore1.getPunteggio() == 3 && giocatore2.getPunteggio() == 3){
				System.out.println(giocatore2.getNome() + " scores > score : deuce");
				//funzione di pareggio
				while(finished==false){
					randomScoreOltranza();
				}
			}
			else if(giocatore2.getPunteggio() == 4){
				System.out.println(giocatore2.getNome() + " scores > score :" + giocatore2.getNome() + " wins.");
				finished = true;
			}
			else
				System.out.println(giocatore2.getNome() + " scores > score :" + giocatore1.getPunteggio() + " - " + giocatore2.getPunteggio());
		}
	}
	
	private void randomScoreOltranza(){
		if(creaGeneratore().nextInt()%2 == 1){
			giocatore1.scoresOltranza();
			if(giocatore1.getPunteggioOltranza() - giocatore2.getPunteggioOltranza() == 2){
				System.out.println(giocatore1.getNome() + " scores > score :" + giocatore1.getNome() + " wins.");
				giocatore1.scores();
				finished = true;
			}
			else if(giocatore1.getPunteggioOltranza() - giocatore2.getPunteggioOltranza() == 1)
				System.out.println(giocatore1.getNome() + " scores > score : adv - " + giocatore2.getPunteggio());
			else if(giocatore1.getPunteggioOltranza() - giocatore2.getPunteggioOltranza() == 0)
				System.out.println(giocatore1.getNome() + " scores > score : deuce");
		}
		else{
			giocatore2.scoresOltranza();
			if(giocatore2.getPunteggioOltranza() - giocatore1.getPunteggioOltranza() == 2){
				System.out.println(giocatore2.getNome() + " scores > score :" + giocatore2.getNome() + " wins.");
				giocatore2.scores();
				finished = true;
			}
			else if(giocatore2.getPunteggioOltranza() - giocatore1.getPunteggioOltranza() == 1)
				System.out.println(giocatore2.getNome() + " scores > score : " + giocatore1.getPunteggio() + " - adv ");
			else if(giocatore2.getPunteggioOltranza() - giocatore1.getPunteggioOltranza() == 0)
				System.out.println(giocatore2.getNome() + " scores > score : deuce");
		}
	}
	
	public void playMatch(){
		while(this.finished == false){
			randomScore();
		}
		System.out.println(this);
	}
}
