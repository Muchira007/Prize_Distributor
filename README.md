This Repository contains java Code that solves this problem:

    lottery company shares out prizes to winning contestants every week. Most weeks, more than one contestant wins, in which case they try to share out the prizes as fairly as possible. Their prize distribution office has hired you to write a program that they will use to distribute prizes in the fairest way possible.

    The program you write should take two lines of input:
    - A comma-separated list of this week's prizes' values
    - A comma-separated names of this week's winners

    For example, the input could be:
    100,800,200,500,400,1000
    Joshua,Mahesh,Lilian

    The program should then output the fairest possible distribution of prizes, by displaying one line for each winner, with the values of the prizes allocated to them. For example, given the input above, the output could be:
    Joshua:100,400,500
    Mahesh:1000
    Lilian:800,200

    The example above gives a perfect solution, where all winners get the same value of prizes (total value of 1000 each). In many cases, this will not be possible, but all prizes must be distributed and cannot be divided. Part of your job is to decide how you define 'fair' for these cases. For example, given the input

    400,400,500,600
    Barry,Sheila,Onyango,Wekesa

    The following would be acceptable output, because there is no fairer distribution possible:
    Barry:400
    Sheila:400
    Onyango:500
    Wekesa:600

The term FAIR in this context is :
=======
    The prize amounts entered are arranged in a descending order then the highest present value is mapped randomly to any one name of winners'. After the first random allocation of prizes a loop is triggered that assigns the highest unassigned value in the arraylist to the least assigned value
        example:

        steve: 1000
        Joshua: 200

        ArrayList(unassignedValues: [800])
        Next iteration -> joshua: 200,800

    if the names entered are more than the available prize it will remove the last person entered following the LIFO principle. In this code any one contender has an equal opportunity to receive the highest prize in the first round and in the next iterations the fair attribute is applied to try and exercise equality.