package cpsc.playingcards;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Color;

import java.util.Stack;

import static java.util.Collections.shuffle;

public class MainActivity extends AppCompatActivity {
    Stack<Card> cardstack;
    String number;
    String suit;
    String color;
    TextView tv1;
    TextView tv2;   //Declare variables for the functions
    ImageView iv1;
    ImageView iv2;  //5 views in total for each suit and number
    ImageView iv3;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relativemain);
        tv1 = (TextView)findViewById(R.id.Number_left);
        tv2 = (TextView)findViewById(R.id.Number_right);
        iv1 = (ImageView)findViewById(R.id.Suit_left);  //Match the views with their ids
        iv2 = (ImageView)findViewById(R.id.Suit_mid);
        iv3 = (ImageView)findViewById(R.id.Suit_right);
        cardstack = new Stack<Card>();
        //Add all of the 52 cards to a stack
        for(int x= 1; x <= 13; ++x)
        {
            if(x==1)    //Is an Ace
            {
                cardstack.push(new Card("A", "Heart", "Red"));
                cardstack.push(new Card("A", "Diamond", "Red"));
                cardstack.push(new Card("A", "Spade", "Black"));
                cardstack.push(new Card("A", "Club", "Black"));
            }
            else if(x==11)  //Is a Jack
            {
                cardstack.push(new Card("J", "Heart", "Red"));
                cardstack.push(new Card("J", "Diamond", "Red"));
                cardstack.push(new Card("J", "Spade", "Black"));
                cardstack.push(new Card("J", "Club", "Black"));
            }
            else if(x==12)  //Is a Queen
            {
                cardstack.push(new Card("Q", "Heart", "Red"));
                cardstack.push(new Card("Q", "Diamond", "Red"));
                cardstack.push(new Card("Q", "Spade", "Black"));
                cardstack.push(new Card("Q", "Club", "Black"));
            }
            else if(x==13)  //Is a King
            {
                cardstack.push(new Card("K", "Heart", "Red"));
                cardstack.push(new Card("K", "Diamond", "Red"));
                cardstack.push(new Card("K", "Spade", "Black"));
                cardstack.push(new Card("K", "Club", "Black"));
            }
            else    //Is 2-10
            {
                cardstack.push(new Card(Integer.toString(x), "Heart", "Red"));
                cardstack.push(new Card(Integer.toString(x), "Diamond", "Red"));
                cardstack.push(new Card(Integer.toString(x), "Spade", "Black"));
                cardstack.push(new Card(Integer.toString(x), "Club", "Black"));
            }
        }
        shuffle(cardstack); //Shuffle the stack for randomness
        PopStack();     //Call function to display a random card on start from off the stack
    }
    public void click(View view)
    {
        if (cardstack.isEmpty())
        {
            finish();   //No cards left in the deck so end
        }
        else
        {
            PopStack();    //Onclick show a new card
        }
    }
    public void PopStack()
    {
        Card c0 = cardstack.pop();
        number = c0.getNum();
        suit = c0.getSuit();
        color = c0.getColor();  //Get the attributes of the card from the card class

        tv1.setText(number);    //Set text to the new card's value
        tv2.setText(number);
        if (color.equals("Red")) {
            tv1.setTextColor(Color.RED);    //Change text color
            tv2.setTextColor(Color.RED);
        }
        else if (color.equals("Black")) {
            tv1.setTextColor(Color.BLACK);
            tv2.setTextColor(Color.BLACK);
        }
        if (suit.equals("Heart")) {
            iv1.setImageResource(R.mipmap.heart);   //Change the suit of the card
            iv2.setImageResource(R.mipmap.heart);
            iv3.setImageResource(R.mipmap.heart);
        }
        else if (suit.equals("Spade")) {
            iv1.setImageResource(R.mipmap.spade);
            iv2.setImageResource(R.mipmap.spade);
            iv3.setImageResource(R.mipmap.spade);
        }
        else if (suit.equals("Club")) {
            iv1.setImageResource(R.mipmap.club);
            iv2.setImageResource(R.mipmap.club);
            iv3.setImageResource(R.mipmap.club);
        }
        else {
            iv1.setImageResource(R.mipmap.diamond);
            iv2.setImageResource(R.mipmap.diamond);
            iv3.setImageResource(R.mipmap.diamond);
        }
    }
}

class Card
{
    private String cardnum;
    private String cardsuit;
    private String cardcolor;
    public Card(String number, String suit, String color)
    {
        cardnum = number;
        cardsuit = suit;
        cardcolor = color;  //Hold the 3 string values and return them when the get is called for each value
    }
    public String getNum()
    {
        return cardnum;
    }
    public String getSuit()
    {
        return cardsuit;
    }
    public String getColor()
    {
        return cardcolor;
    }
}