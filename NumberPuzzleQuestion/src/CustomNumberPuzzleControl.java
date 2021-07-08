import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		swapButton(buttons[emptyCellId],buttonClicked);
		for(int i=0;i<16;i++)
			if(buttons[i].getLabel()==buttonClicked.getLabel()) {
				//swapButton(buttons[emptyCellId],buttons[i]);

				return i;
			}
		//Your logic here		
		
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];

		for(int i=1;i<=15;i++)
		{
			int a = (int)(Math.random()*15);

			if(arr[a]!=0) {
				while (arr[(++a)%15] != 0) ;
			}
			arr[a%15] = i;
		}
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		for(int i=0;i<15;i++)
		{
			if(buttons[i].getLabel()=="	")
				return false;
			if(Integer.parseInt(buttons[i].getLabel())!=i+1)
				return false;
		}
		// Your Logic here
		getIntegerArrayOfButtonIds(buttons);

		return winner;
	}
}