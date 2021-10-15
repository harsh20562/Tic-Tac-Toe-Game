package com.company;

import java.io.*;
import java.util.Random;
import java.util.*;

class Board {
    ArrayList<Integer> user_set = new ArrayList<Integer>();
    ArrayList<Integer> comp_set = new ArrayList<Integer>();
    public void show_board(char[][] tic_board) {
        for(int i = 0; i<tic_board.length; ++i)
        {
            for(int j = 0; j<tic_board[0].length; ++j)
            {
                System.out.print(tic_board[i][j]);
            }
            System.out.println();
        }
    }
    public char[][] move(char[][] tic_board, String user, int position)
    {
        char symbol;
        if(user.equals("You"))
        {
            symbol = 'X';
            user_set.add(position);
        }
        else
        {
            symbol = 'O';
            comp_set.add(position);
        }
        if(position==1)
        {
            tic_board[0][0] = symbol;
        }
        else if(position==2)
        {
            tic_board[0][3] = symbol;
        }
        else if(position==3)
        {
            tic_board[0][6] = symbol;
        }
        else if(position==4)
        {
            tic_board[2][0] = symbol;
        }
        else if(position==5)
        {
            tic_board[2][3] = symbol;
        }
        else if(position==6)
        {
            tic_board[2][6] = symbol;
        }
        else if(position==7)
        {
            tic_board[4][0] = symbol;
        }
        else if(position==8)
        {
            tic_board[4][3] = symbol;
        }
        else if(position==9)
        {
            tic_board[4][6] = symbol;
        }
        return tic_board;
    }
}

class tictactoe {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] tictactoe_board = {
                {' ',' ','|',' ',' ','|',' ',' '},
                {'-','-','|','-','-','|','-','-'},
                {' ',' ','|',' ',' ','|',' ',' '},
                {'-','-','|','-','-','|','-','-'},
                {' ',' ','|',' ',' ','|',' ',' '}
        };
        Board b = new Board();
        int c = 1;
        Random rand = new Random();
        int i=1;
        while(i<=9)
        {
            b.show_board(tictactoe_board);
            c = 1;
            System.out.print("Enter the positions from 1-9 : ");
            int user_pos = scn.nextInt();
            while(b.user_set.contains(user_pos) || b.comp_set.contains(user_pos))
            {
                System.out.println("Enter the positions from 1-9");
                user_pos = scn.nextInt();
            }
            ++i;
            tictactoe_board = b.move(tictactoe_board,"You", user_pos);
            if(iswinning(tictactoe_board)!="False")
            {
                String s = iswinning(tictactoe_board);
                System.out.println(s + " won");
                c = 0;
                break;
            }
            c = 1;
            int comp_pos = rand.nextInt(10);
            while(b.user_set.contains(comp_pos) || b.comp_set.contains(comp_pos))
            {
                comp_pos = rand.nextInt(10);
            }
            ++i;
            tictactoe_board = b.move(tictactoe_board, "Comp", comp_pos);
            if(iswinning(tictactoe_board)!="False")
            {
                String s = iswinning(tictactoe_board);
                System.out.println(s + " won");
                c = 0;
                break;
            }
        }
        System.out.println("\n");
        b.show_board(tictactoe_board);
        if(c==1)
        {
            System.out.println("Its a tie");
        }
    }
    public static String iswinning(char[][] tic_board)
    {
        if(tic_board[0][0]==tic_board[0][3] && tic_board[0][3]==tic_board[0][6] && tic_board[0][0]=='O')
        {
            return "Comp";
        }
        else if(tic_board[0][0]==tic_board[0][3] && tic_board[0][3]==tic_board[0][6] && tic_board[0][0]=='X')
        {
            return "You";
        }
        if(tic_board[2][0]==tic_board[2][3] && tic_board[2][3]==tic_board[2][6] && tic_board[2][0]=='O')
        {
            return "Comp";
        }
        else if(tic_board[2][0]==tic_board[2][3] && tic_board[2][3]==tic_board[2][6] && tic_board[2][0]=='X')
        {
            return "You";
        }
        if(tic_board[4][0]==tic_board[4][3] && tic_board[4][3]==tic_board[4][6] && tic_board[4][0]=='O')
        {
            return "Comp";
        }
        else if(tic_board[4][0]==tic_board[4][3] && tic_board[4][3]==tic_board[4][6] && tic_board[4][0]=='X')
        {
            return "You";
        }
        if(tic_board[0][0]==tic_board[2][0] && tic_board[2][0]==tic_board[4][0] && tic_board[0][0]=='O')
        {
            return "Comp";
        }
        else if(tic_board[0][0]==tic_board[2][0] && tic_board[2][0]==tic_board[4][0] && tic_board[0][0]=='X')
        {
            return "You";
        }
        if(tic_board[0][3]==tic_board[2][3] && tic_board[2][3]==tic_board[4][3] && tic_board[0][3]=='O')
        {
            return "Comp";
        }
        else if(tic_board[0][3]==tic_board[2][3] && tic_board[2][3]==tic_board[4][3] && tic_board[0][3]=='X')
        {
            return "You";
        }
        if(tic_board[0][6]==tic_board[2][6] && tic_board[2][6]==tic_board[4][6] && tic_board[0][6]=='O')
        {
            return "Comp";
        }
        else if(tic_board[0][6]==tic_board[2][6] && tic_board[2][6]==tic_board[4][6] && tic_board[0][6]=='X')
        {
            return "You";
        }
        if(tic_board[0][0]==tic_board[2][3] && tic_board[2][3]==tic_board[4][6] && tic_board[0][0]=='O')
        {
            return "Comp";
        }
        else if(tic_board[0][0]==tic_board[2][3] && tic_board[2][3]==tic_board[4][6] && tic_board[0][0]=='X')
        {
            return "You";
        }
        if(tic_board[0][6]==tic_board[2][3] && tic_board[2][3]==tic_board[4][0] && tic_board[0][6]=='O')
        {
            return "Comp";
        }
        else if(tic_board[0][6]==tic_board[2][3] && tic_board[2][3]==tic_board[4][0] && tic_board[0][6]=='X')
        {
            return "You";
        }
        return "False";
    }
}
