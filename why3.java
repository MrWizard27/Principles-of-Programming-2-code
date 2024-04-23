import java.util.Scanner;
            //Name of file
public class why3{

public static void Introconversation(String str) {

    switch (str) {
      case "Hello There":
      case "hello there":
      case "HELLO THERE":
      case "Hello there":
      System.out.println("Kenobi?");
      break;
      case "Nothin Much":
      case "nothin much":
      case "Nothin much":
      System.out.println("Thats Boring");
      break;
      case "Execute Order 66":
      case "execute order 66":
      case "Execute order 66":
      System.out.println("Death to the Jedi!");
      break;
      case "What is the meaning of life":
      case "what is the meaning of life":
      case "What is the Meaning of Life":
      case "What is the meaning of Life":
      case "What's the meaning of life":
      case "what's the meaning of life":
      case "What's the meaning of Life":
      System.out.println("I dont know bro, I just work  here");
      break;
      case "Up Up Down Down Left Right Left Right B A Start":
      case "up up down down left right left right b a start":
      System.out.println("Hwhat");
      break;
      case "The Sky":
      case "the sky":
      case "The sky":
      System.out.println("No dib Sherlock");
      break;
      case "Threat Level Midnight":
      case "threat level midnight":
      case "Threat level midnight":
      System.out.println("I don't watch The Office");
      break;
      case "Dukes up":
      case "dukes up":
      case "Dukes Up":
      case "Dukes up!":
      case "Dukes Up!":
      System.out.println("Bonks with crown");
      System.exit(0);
      break;
      case "Dad?!":
      case "Dad!?":
      case "dad!?":
      case "dad?!":
      case "Dad?":
      case "dad?":
      case "Dad!":
      case "dad!":
      case "DAD":
      case "dad":
      case "Dad":
      System.out.println("Yes son");
      break;
      case "Blows up pancakes with mind":
      case "blows up pancakes with mind":
      case "Blows up Pancakes with Mind":
      case "Blows up pancakes with Mind":
      case "BLOWS UP PANCAKES WITH MIND":
      System.out.println("My fudgin panca-");
      System.exit(0);
      break;
      case "Howdy":
      case "howdy":
      System.out.println("*Tips Hat*");
      break;
      case "Your mom":
      case "your mom":
      case "ur mom":
      case "Your mother":
      System.out.println("Why");
      break;
      default:
      System.out.println("I don't do english too well partner so im just gonna nod my head");
      break;

  }
}
public static void Queststart(String sw) {
Scanner input = new Scanner(System.in);
System.out.println("");
System.out.println("Adventurer, I have a quest for you");
System.out.println("Would you be willing to fetch me a Regen artifact.\nI'm willing to pay you 100 gold coins for it.\nDo you accept (yes/no)");
int n = 0;
while (n!=1){
  String nl = input.nextLine();
  //nl= new lines
  switch (nl) {
  case "no":
  case "No":
  System.out.println("ok :(");
  System.exit(0);
  break;
  case "yes":
  case "Yes":
  case "s":
  System.out.println("");
  System.out.println("Great, here is what you need to do.");
  n = 1;
  break;
  default:
  System.out.println("Thats not an answer");
  break;
  }
}
//Adventure plan
System.out.println("Go through the haunted forest, watch out for monsters,\nOnce you get out of there climb up the mountain and look for a chest.");
System.out.println("Once you find the chest, whisper the Sentence \"" + sw + "\" and it will open,\ninside will be the regen artifact");
System.out.println("\nBefore you go, take this Magical sword, now go adventurer.");
}
public static void HauntedForestP1() {
  Scanner input = new Scanner(System.in);
  int n = 0;
  //Entering the forest
  System.out.println("\nYou enter the haunted forest\nA Skeleton appears, what will you do?");
  //Fight Options
  System.out.println("\nAttack\nBlock\nRun\nCry");
  while (n!=1){
  String ml = input.nextLine();
  //ml = mission lines
  switch (ml) {
  default:
  System.out.println("Thats not one of the 4 options, if you are bad at spelling just type the number of the option you want, ie. 4 or Option 4");
  break;
  case "Cry":
  case "cry":
  case "4":
  case "Option 4":
  System.out.println("");
  System.out.println("Wha- why did you pick this option, is the Skeleton really that scary? fine, uh you win, congrats!");
  System.out.println("\nYOU WIN\nCONGRATULATIONS\n\nHidden Ending\n(are you ok?)");
  System.exit(0);
  break;
  case "Run":
  case "run":
  case "3":
  case "Option 3":
  System.out.println("You attempt to run away and trip hitting your head and dying instantly");
  System.out.println("Mission Failed, We'll get em next time");
  System.exit(0);
  break;
  case "Block":
  case "block":
  case "2":
  case "Option 2":
  System.out.println("The Skeleton get ready to swing, you go into a blocking stance ready to block their next move");
  System.out.println("The Skeleton swings it's sword, You block the hit, sliding back.\nYou run at the Skeleton who is struggling to recover from its swing as it has literally no muscles.\nYou reach the Skeleton\nSwing //");
  System.out.println("With one swing the skeleton falls apart, you have won this battle");
  n = 1;
  break;
  case "attack":
  case "Attack":
  case "attack it":
  case "Attack it":
  case "1":
  case "Option 1":
  case "s":
  System.out.println("You ready your sword and widen your stance. The Skeleton seems to mimic your moves as if it has no moves of it's own.\nYou breath in.... Then out...\nYou both swing at the same time");
  System.out.println("Your slice was perfect, the Skeleton's swing cutting only a single strand of hair off your head");
  System.out.println("The Skeleton Crumbles, you have won this fight");
  n = 1;
  break;
  }
}
}
public static void HauntedForestP2(String sw) {
  Scanner input = new Scanner(System.in);
  int n = 0 ;
  System.out.println("");
  System.out.println("Now that the skeleton has been defeated it is time to move on through the forest.");
  System.out.println("You continue walking through the haunted forest\nYou are now half way through the forest when suddenly, A Black Bear walks up to you\nWhat do you do?");
  System.out.println("\n1.Attack\n2.Block\n3.Put Your Arms in the air and start screaming\n4.Shoot it\n5.Run away\n6.Dance Battle");
  while (n!=1){
  String f2 = input.nextLine();
  //f2 = forest 2
  switch (f2) {
  default:
  System.out.println("Thats not one of the 6 options, if you are bad at spelling just type the number of the option you want, ie. 6 or Option 6");
  break;
  case "attack":
  case "Attack":
  case "attack it":
  case "Attack it":
  case "1":
  case "Option 1":
  case "option 1":
  case "One":
  case "one":
  System.out.println("\nYou swing your sword at the bear\nYour sword only gets through 3cm of flesh before getting stuck in the bear's muscle\nNow your sword is stuck and the bear is angry\nThe Bear absolutely destroys you, You didn't even have time to react\nYou Are Dead");
  System.exit(0);
  break;
  case "Block":
  case "block":
  case "2":
  case "Option 2":
  case "option 2":
  case "Two":
  case "two":
  System.out.println("\nYou get in a defensive stance, Sword at an angle, ready to deflect any attack sent at it\nThe bear just stands there, looking at the shiny metal of the blade");
  System.out.println("It looks like the bear has no intent to attack you, just examining you, like a cat that curiosity can't kill\nMaybe its not your enemy,\nMaybe it could even be your friend");
  System.out.println("You decide to befriend the beast as it seem pretty chill\nYou continue on your quest with ease as the bear is able to defeat any enemy who tries to harm you\nYou easily reach the mountain and on the top is a powerful looking creature who guards the chest");
  System.out.println("You get ready for battle, but then the creature screams and runs away saying \"AHH A BEAR, IM DEATHLY AFRAID OF BEARS!!\"\nKinda weird to be that powerful and be afraid of a bear but im afraid of spiders and could easily kill them so I guess I can't judge.");
  System.out.println("You whisper the magic word \"" + sw + "\"and the chest opens revealing the regen crystal,\nan orange dodecahedron that feels warm to the touch\nYou ride away on your new bear friend,completing your mission");
  System.out.println("\nYou Win!\nHidden Ending\n(The bears name is BMO)");
  break;
  case "Put Your Arms in the air and start screaming":
  case "Put my Arms in the air and start screaming":
  case "Put your arms in the air and start screaming":
  case "Put Your Arms In The Air And Start Screaming":
  case "put Your arms In The air And start screaming":
  case "Put my hands up":
  case "3":
  case "Option 3":
  case "option 3":
  case "Three":
  case "three":
  case "Scare the Bear":
  case "Scare it":
  case "s":
  System.out.println("\nYou raise your hands to make yourself look bigger and start screaming\nThe bear thinks you've gone insane and decides to leave you along\nThe bear walks away\nCongratualtions you did it, the bear is gone\nOnwards");
  n = 1;
  break;
  case "shoot it":
  case "Shoot it":
  case "Catch em lackin":
  case "4":
  case "Option 4":
  case "option 4":
  case "Four":
  case "four":
  System.out.println("\nYou don't even have a gun, Why did you think that would work, Well the bear has already mauled you but thats not the important part,\nThe important part is that you have an iq of 2 and should feel bad");
  System.out.println("You Have Died");
  System.out.println("(Personally I wouldn't take that disrespect)");
  System.exit(0);
  break;
  case "Run Away":
  case "run away":
  case "Run away":
  case "RUN AWAY":
  case "Option 5":
  case "5":
  case "option 5":
  case "five":
  case "Five":
  System.out.println("You turn around and book it, running faster than you've ever run before\nThe bear now percieves you as prey and starts chasing after you\nYou may be fast but the bear is faster\nThe bear catches up to you in mere seconds and mauls you.");
  System.out.println("You are dead");
  System.out.println("(Dude that was the number 1 thing not to do if you see a bear, have you learned nothing in school)");
  System.exit(0);
  break;
  case "Dance Battle":
  case "dance battle":
  case "Dance battle":
  case "6":
  case "Option 6":
  case "option 6":
  case "six":
  case "Six":
  System.out.println("You pop your favorite song into a boombox and start jamming, The sheer vibes and dances moves is enough to shatter the bears sense of reality\nThe bear runs into the forest unaware of where it is or who it really is");
  System.out.println("You have defeated the bear,\nOnwards");
  n = 1;
  break;
  }
}
}
//public static void ForestExit() {
//Scanner input = new Scanner(System.in);
//int n = 0;
//System.out.println("You see a light at the end of the forest, You are almost at the end");
//System.out.println("But what's this!?\n ");
//}
public static void main(String[] args) {
  Scanner input = new Scanner(System.in);
  //secret word (change to whatever you want)
  String sw = "The One Piece, The One Piece is real!";

  System.out.println("Wattup Son!");
  Introconversation(input.nextLine());
  Queststart(sw);
  HauntedForestP1();
  HauntedForestP2(sw);
  //ForestExit();
  }
}
//note for later: remove the temporary option s that just skips to the right decision
