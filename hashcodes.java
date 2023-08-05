import java.util.*;
class tik_tac_tae
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println();
        System.out.println("....................Tik Tac Tae....................");
        System.out.println("Enter the name of 1st player:");
        String p1=sc.nextLine();
        System.out.println("Enter the name of 2nd player:");
        String p2=sc.nextLine();

        char[][] board=new char[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j]='_';
            }
        }
        boolean isPlayer=true;
        boolean gamend=false;
        while(!gamend)
        {
            drawB(board);

            
            char symbol=' ';
            if(isPlayer)
            {
                symbol='x';
            }
            else
            {
                symbol='o';
            }
            int row=0;
            int col=0;
            while(true)
            {
                System.out.println();
                System.out.print("Enter a row num 0,1 or 2: ");
                row=sc.nextInt();
                System.out.print("Enter a column num 0,1 or 2: ");
                col=sc.nextInt();
                System.out.println();

                if(row<0||col<0||row>2||col>2)
                {
                    System.out.println("Enter valid number of row and columan...");
                }
                else if(board[row][col]!='_')
                {
                    System.out.println("Player already made a move there...");
                }
                else
                {
                    break;
                }
            }    
            board[row][col]=symbol;
            
            if(won(board)=='x')
            {
                System.out.println(p1+" is winner...");
                gamend=true;
            }
            else if(won(board)=='o')
            {
                System.out.println(p2+" is winner...");
                gamend=true;
            }
            else
            {
                if(tied(board))
                {
                System.out.println("Tie");
                gamend=true;
                }
                else
                {
                    isPlayer=!isPlayer;
                }
            }
        }    
    }
    public static void drawB(char[][] board)
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(board[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static char won(char[][] board)
    {
        for(int i=0;i<3;i++)
        {
            if(board[i][0]==board[i][1]&& board[i][1]==board[i][2] && board[i][0]!='_')
            {
                return board[i][0];
            }
        }

        for(int j=0;j<3;j++)
        {
            if(board[0][j]==board[1][j]&& board[1][j]==board[2][j] && board[0][j]!='_')
            {
                return board[0][j];
            }
        }

        if(board[0][0]==board[1][1] && board[1][1]==board[2][2] && board[0][0]!='_')
        {
            return board[0][0];
        }

        if(board[2][0]==board[1][1] && board[1][1]==board[0][2] && board[2][0]!='_')
        {
            return board[2][0];
        }
        return '_';
    }

    public static boolean tied(char[][] board)
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]=='_')
                return false;
            }
        }
        return true;
    }
}