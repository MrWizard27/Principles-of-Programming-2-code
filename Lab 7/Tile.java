public class Tile{ 

    private char letter;
    private int value;

public Tile(char l, int v){
    this.letter = l;
    this.value = v;
}

public char GetLetter(){
return this.letter;
}

public int GetValue(){
return this.value;
}

public void SetLetter(){
this.letter = letter;
}

public void SetValue(){
this.value = value;    
}

public String toString(){
    return "Letter: " + this.letter + "\nValue: " + this.value;
}

public boolean equals(Tile that){
    return this.letter == that.letter && this.value == that.value;
}

public static void printTile(Tile t){
    System.out.println("Letter: " + t.letter + "\nValue: " + t.value);
    }
}