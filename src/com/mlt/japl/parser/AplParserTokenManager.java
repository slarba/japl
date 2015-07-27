/* Generated By:JavaCC: Do not edit this line. AplParserTokenManager.java */
package com.mlt.japl.parser;
import java.io.Reader;
import com.mlt.japl.iface.*;
import com.mlt.japl.fns.*;
import com.mlt.japl.ast.*;
import com.mlt.japl.errors.*;
import com.mlt.japl.workspace.*;
import java.util.ArrayList;
import java.util.List;

/** Token Manager. */
public class AplParserTokenManager implements AplParserConstants
{
  // trick: check identifier if it is bound to function and make it a FUNC token
  // in effect modifies the parser dynamically
  public void CommonTokenAction(Token t)
  {
        EvalContext ctx = parser.getContext();
        if(t.kind==AplParserConstants.ID)
        {
                if(ctx.isBoundToFunction(t.image))
                {
                  t.kind = AplParserConstants.FUNC;
                }
        }
  }

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }

  /** The parser. */
  public AplParser parser = null;
private final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 40:
         return jjStopAtPos(0, 19);
      case 41:
         return jjStopAtPos(0, 20);
      case 46:
         return jjStopAtPos(0, 36);
      case 58:
         return jjMoveStringLiteralDfa1_0(0x3fe00000L);
      case 59:
         return jjStopAtPos(0, 33);
      case 91:
         return jjStopAtPos(0, 30);
      case 93:
         return jjStopAtPos(0, 31);
      case 123:
         return jjStopAtPos(0, 34);
      case 125:
         return jjStopAtPos(0, 35);
      case 8592:
         return jjStopAtPos(0, 32);
      case 8728:
         return jjMoveStringLiteralDfa1_0(0x80L);
      case 8900:
         return jjStopAtPos(0, 18);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 46:
         if ((active0 & 0x80L) != 0L)
            return jjStopAtPos(1, 7);
         break;
      case 68:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000000L);
      case 69:
         return jjMoveStringLiteralDfa2_0(active0, 0x29800000L);
      case 73:
         return jjMoveStringLiteralDfa2_0(active0, 0x200000L);
      case 82:
         return jjMoveStringLiteralDfa2_0(active0, 0x10000000L);
      case 84:
         return jjMoveStringLiteralDfa2_0(active0, 0x400000L);
      case 87:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000000L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x10000000L);
      case 102:
         if ((active0 & 0x200000L) != 0L)
            return jjStopAtPos(2, 21);
         break;
      case 104:
         return jjMoveStringLiteralDfa3_0(active0, 0x2400000L);
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x800000L);
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x29000000L);
      case 111:
         if ((active0 & 0x4000000L) != 0L)
            return jjStopAtPos(2, 26);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 100:
         return jjMoveStringLiteralDfa4_0(active0, 0x29000000L);
      case 101:
         return jjMoveStringLiteralDfa4_0(active0, 0x400000L);
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x2000000L);
      case 112:
         return jjMoveStringLiteralDfa4_0(active0, 0x10000000L);
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x800000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 73:
         return jjMoveStringLiteralDfa5_0(active0, 0x1000000L);
      case 82:
         return jjMoveStringLiteralDfa5_0(active0, 0x20000000L);
      case 87:
         return jjMoveStringLiteralDfa5_0(active0, 0x8000000L);
      case 101:
         if ((active0 & 0x800000L) != 0L)
            return jjStopAtPos(4, 23);
         return jjMoveStringLiteralDfa5_0(active0, 0x10000000L);
      case 108:
         return jjMoveStringLiteralDfa5_0(active0, 0x2000000L);
      case 110:
         if ((active0 & 0x400000L) != 0L)
            return jjStopAtPos(4, 22);
         break;
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa6_0(active0, 0x10000000L);
      case 101:
         if ((active0 & 0x2000000L) != 0L)
            return jjStopAtPos(5, 25);
         return jjMoveStringLiteralDfa6_0(active0, 0x20000000L);
      case 102:
         if ((active0 & 0x1000000L) != 0L)
            return jjStopAtPos(5, 24);
         break;
      case 104:
         return jjMoveStringLiteralDfa6_0(active0, 0x8000000L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 105:
         return jjMoveStringLiteralDfa7_0(active0, 0x8000000L);
      case 112:
         return jjMoveStringLiteralDfa7_0(active0, 0x20000000L);
      case 116:
         if ((active0 & 0x10000000L) != 0L)
            return jjStopAtPos(6, 28);
         break;
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
private int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 101:
         return jjMoveStringLiteralDfa8_0(active0, 0x20000000L);
      case 108:
         return jjMoveStringLiteralDfa8_0(active0, 0x8000000L);
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
private int jjMoveStringLiteralDfa8_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0);
      return 8;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa9_0(active0, 0x20000000L);
      case 101:
         if ((active0 & 0x8000000L) != 0L)
            return jjStopAtPos(8, 27);
         break;
      default :
         break;
   }
   return jjStartNfa_0(7, active0);
}
private int jjMoveStringLiteralDfa9_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(7, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(8, active0);
      return 9;
   }
   switch(curChar)
   {
      case 116:
         if ((active0 & 0x20000000L) != 0L)
            return jjStopAtPos(9, 29);
         break;
      default :
         break;
   }
   return jjStartNfa_0(8, active0);
}
static final long[] jjbitVec0 = {
   0x0L, 0x20000000L, 0x0L, 0x0L
};
static final long[] jjbitVec1 = {
   0xfffffffffffffffeL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec3 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec4 = {
   0x0L, 0x0L, 0x0L, 0x80000000800000L
};
static final long[] jjbitVec5 = {
   0x0L, 0x0L, 0xa0000L, 0x0L
};
static final long[] jjbitVec6 = {
   0x1000058800040100L, 0x3300000000L, 0x300040000cL, 0x40L
};
static final long[] jjbitVec7 = {
   0x2200000000000500L, 0x1e000080244a00L, 0x0L, 0x0L
};
static final long[] jjbitVec8 = {
   0x0L, 0x0L, 0x0L, 0x800L
};
static final long[] jjbitVec9 = {
   0x0L, 0x0L, 0x10000000000L, 0x0L
};
static final long[] jjbitVec10 = {
   0x8000000000000000L, 0x1L, 0x0L, 0x0L
};
static final long[] jjbitVec11 = {
   0x0L, 0x0L, 0x2000000000000L, 0x200L
};
static final long[] jjbitVec12 = {
   0x0L, 0x100000000000L, 0x0L, 0x0L
};
static final long[] jjbitVec13 = {
   0x0L, 0x0L, 0x800000000000L, 0x0L
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 22;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 10)
                        kind = 10;
                     jjCheckNAddStates(0, 4);
                  }
                  else if ((0xf000180200000000L & l) != 0L)
                  {
                     if (kind > 6)
                        kind = 6;
                  }
                  else if (curChar == 39)
                     jjCheckNAdd(7);
                  else if (curChar == 47)
                  {
                     if (kind > 8)
                        kind = 8;
                  }
                  break;
               case 1:
                  if ((0xfffffffffffffbffL & l) != 0L)
                     jjAddStates(5, 6);
                  break;
               case 2:
                  if (curChar == 10 && kind > 5)
                     kind = 5;
                  break;
               case 3:
                  if ((0xf000180200000000L & l) != 0L && kind > 6)
                     kind = 6;
                  break;
               case 4:
                  if (curChar == 47 && kind > 8)
                     kind = 8;
                  break;
               case 6:
                  if (curChar == 39)
                     jjCheckNAdd(7);
                  break;
               case 7:
                  if ((0xffffff7fffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(7, 8);
                  break;
               case 8:
                  if (curChar == 39 && kind > 12)
                     kind = 12;
                  break;
               case 10:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 10)
                     kind = 10;
                  jjCheckNAddTwoStates(10, 11);
                  break;
               case 11:
                  if (curChar == 46)
                     jjCheckNAdd(12);
                  break;
               case 12:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 10)
                     kind = 10;
                  jjCheckNAdd(12);
                  break;
               case 13:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddStates(7, 9);
                  break;
               case 14:
                  if (curChar == 46)
                     jjCheckNAdd(15);
                  break;
               case 15:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(15, 16);
                  break;
               case 18:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 11)
                     kind = 11;
                  jjAddStates(10, 11);
                  break;
               case 19:
                  if (curChar == 46)
                     jjCheckNAdd(20);
                  break;
               case 20:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 11)
                     kind = 11;
                  jjCheckNAdd(20);
                  break;
               case 21:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 10)
                     kind = 10;
                  jjCheckNAddStates(0, 4);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x7fffffe07fffffeL & l) != 0L)
                  {
                     if (kind > 9)
                        kind = 9;
                     jjCheckNAdd(5);
                  }
                  else if (curChar == 92)
                  {
                     if (kind > 8)
                        kind = 8;
                  }
                  break;
               case 1:
                  jjAddStates(5, 6);
                  break;
               case 4:
                  if (curChar == 92 && kind > 8)
                     kind = 8;
                  break;
               case 5:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 9)
                     kind = 9;
                  jjCheckNAdd(5);
                  break;
               case 7:
                  jjAddStates(12, 13);
                  break;
               case 16:
                  if (curChar == 74)
                     jjAddStates(14, 15);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (int)(curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(1, 2);
                  if (jjCanMove_2(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 6)
                        kind = 6;
                  }
                  if (jjCanMove_3(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 8)
                        kind = 8;
                  }
                  if (jjCanMove_4(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 9)
                        kind = 9;
                     jjCheckNAdd(5);
                  }
                  if (jjCanMove_5(hiByte, i1, i2, l1, l2))
                     jjAddStates(16, 17);
                  break;
               case 1:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(1, 2);
                  break;
               case 3:
                  if (jjCanMove_2(hiByte, i1, i2, l1, l2) && kind > 6)
                     kind = 6;
                  break;
               case 4:
                  if (jjCanMove_3(hiByte, i1, i2, l1, l2) && kind > 8)
                     kind = 8;
                  break;
               case 5:
                  if (!jjCanMove_4(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 9)
                     kind = 9;
                  jjCheckNAdd(5);
                  break;
               case 7:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjAddStates(12, 13);
                  break;
               case 9:
                  if (jjCanMove_5(hiByte, i1, i2, l1, l2))
                     jjAddStates(16, 17);
                  break;
               case 17:
                  if (jjCanMove_5(hiByte, i1, i2, l1, l2))
                     jjstateSet[jjnewStateCnt++] = 18;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 22 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   10, 11, 13, 14, 16, 1, 2, 13, 14, 16, 18, 19, 7, 8, 17, 18, 
   10, 13, 
};
private static final boolean jjCanMove_0(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 35:
         return ((jjbitVec0[i2] & l2) != 0L);
      default :
         return false;
   }
}
private static final boolean jjCanMove_1(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec3[i2] & l2) != 0L);
      default :
         if ((jjbitVec1[i1] & l1) != 0L)
            return true;
         return false;
   }
}
private static final boolean jjCanMove_2(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec4[i2] & l2) != 0L);
      case 33:
         return ((jjbitVec5[i2] & l2) != 0L);
      case 34:
         return ((jjbitVec6[i2] & l2) != 0L);
      case 35:
         return ((jjbitVec7[i2] & l2) != 0L);
      case 37:
         return ((jjbitVec8[i2] & l2) != 0L);
      default :
         return false;
   }
}
private static final boolean jjCanMove_3(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec9[i2] & l2) != 0L);
      case 35:
         return ((jjbitVec10[i2] & l2) != 0L);
      default :
         return false;
   }
}
private static final boolean jjCanMove_4(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 3:
         return ((jjbitVec11[i2] & l2) != 0L);
      case 35:
         return ((jjbitVec12[i2] & l2) != 0L);
      default :
         return false;
   }
}
private static final boolean jjCanMove_5(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec13[i2] & l2) != 0L);
      default :
         return false;
   }
}

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, "\u2218\56", null, null, null, null, 
null, null, null, null, null, null, "\u22c4", "\50", "\51", "\72\111\146", 
"\72\124\150\145\156", "\72\105\154\163\145", "\72\105\156\144\111\146", "\72\127\150\151\154\145", 
"\72\104\157", "\72\105\156\144\127\150\151\154\145", "\72\122\145\160\145\141\164", 
"\72\105\156\144\122\145\160\145\141\164", "\133", "\135", "\u2190", "\73", "\173", "\175", "\56", };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0x1ffffc1fc1L, 
};
static final long[] jjtoSkip = {
   0x3eL, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[22];
private final int[] jjstateSet = new int[44];
protected char curChar;

/** Constructor with parser. */
public AplParserTokenManager(AplParser parserArg, SimpleCharStream stream){
   parser = parserArg;
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor with parser. */
public AplParserTokenManager(AplParser parserArg, SimpleCharStream stream, int lexState){
   this(parserArg, stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 22; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      CommonTokenAction(matchedToken);
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         CommonTokenAction(matchedToken);
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
