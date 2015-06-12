/* The following code was generated by JFlex 1.4.3 on 6/11/15 7:45 PM */

package analysis;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import errorHandler.ModuloDeErrores;
import java_cup.runtime.Symbol;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 6/11/15 7:45 PM from the specification file
 * <tt>/home/zyoruk/Projects/workspace/Compi/MarbleWorldHW/src/analysis/AnalisisLexico.flex</tt>
 */
public class AnalizadorLexico implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\2\1\0\1\3\1\1\22\0\1\3\1\32\6\0"+
    "\1\37\1\40\1\35\1\33\1\0\1\34\1\0\1\36\12\4\2\0"+
    "\1\30\1\31\1\27\2\0\1\53\1\5\1\51\1\50\1\11\1\61"+
    "\1\5\1\62\1\60\2\5\1\52\1\55\1\63\1\56\1\10\1\5"+
    "\1\54\1\64\1\6\1\67\1\57\1\65\1\5\1\7\1\5\4\0"+
    "\1\12\1\0\1\21\1\5\1\13\1\43\1\44\1\24\1\26\1\20"+
    "\1\23\2\5\1\25\1\45\1\15\1\14\2\5\1\22\1\16\1\17"+
    "\1\66\1\46\1\47\3\5\1\41\1\0\1\42\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\1\3\1\4\10\1\1\5\1\6"+
    "\1\7\1\1\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\11\1\1\2\1\4\13\0\1\20\2\0"+
    "\1\21\1\22\1\23\1\24\1\25\21\0\1\26\13\0"+
    "\1\27\1\30\1\31\4\0\1\32\4\0\1\33\2\0"+
    "\1\34\1\0\1\35\1\0\1\33\6\0\1\33\1\36"+
    "\35\33";

  private static int [] zzUnpackAction() {
    int [] result = new int[142];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\70\0\160\0\250\0\70\0\340\0\u0118\0\u0150"+
    "\0\u0188\0\u01c0\0\u01f8\0\u0230\0\u0268\0\u02a0\0\u02d8\0\u0310"+
    "\0\u0348\0\u0380\0\70\0\70\0\70\0\70\0\70\0\70"+
    "\0\70\0\70\0\u03b8\0\u03f0\0\u0428\0\u0460\0\u0498\0\u04d0"+
    "\0\u0508\0\u0540\0\u0578\0\70\0\u05b0\0\u0118\0\u05e8\0\u0620"+
    "\0\u0658\0\u0690\0\u06c8\0\u0700\0\u0738\0\u0770\0\u07a8\0\u07e0"+
    "\0\u0118\0\u0818\0\u0850\0\70\0\70\0\70\0\70\0\u0118"+
    "\0\u0888\0\u08c0\0\u08f8\0\u0930\0\u0968\0\u09a0\0\u09d8\0\u0a10"+
    "\0\u0a48\0\u0a80\0\u0ab8\0\u0af0\0\u0b28\0\u0b60\0\u0b98\0\u0bd0"+
    "\0\u0c08\0\u0118\0\u0c40\0\u0c78\0\u0cb0\0\u0ce8\0\u0d20\0\u0d58"+
    "\0\u0d90\0\u0dc8\0\u0e00\0\u0e38\0\u0e70\0\u0118\0\u0118\0\u0118"+
    "\0\u0ea8\0\u0ee0\0\u0f18\0\u0f50\0\u0118\0\u0f88\0\u0fc0\0\u0ff8"+
    "\0\u1030\0\u1068\0\u10a0\0\u10d8\0\u0118\0\u1110\0\u0118\0\u1148"+
    "\0\u1180\0\u11b8\0\u01f8\0\u11f0\0\u1228\0\u1260\0\u1298\0\u12d0"+
    "\0\u0118\0\u1308\0\u1340\0\u1378\0\u13b0\0\u13e8\0\u1420\0\u1458"+
    "\0\u1490\0\u14c8\0\u1500\0\u1538\0\u1570\0\u15a8\0\u15e0\0\u1618"+
    "\0\u1650\0\u1688\0\u16c0\0\u16f8\0\u1730\0\u1768\0\u17a0\0\u17d8"+
    "\0\u1810\0\u1848\0\u1880\0\u18b8\0\u18f0\0\70";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[142];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\7"+
    "\1\11\1\2\1\12\2\7\1\13\1\14\3\7\1\15"+
    "\1\16\2\7\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\7\1\36\1\37\4\7\1\40\2\7\1\41"+
    "\1\42\3\7\1\43\2\7\72\0\1\44\66\0\1\44"+
    "\66\0\2\45\1\0\1\45\1\6\63\45\6\46\1\47"+
    "\67\46\1\47\45\46\1\50\5\46\1\51\13\46\1\47"+
    "\43\46\1\52\23\46\1\47\5\46\1\53\3\46\1\54"+
    "\55\46\1\47\10\46\1\55\56\46\1\47\11\46\1\56"+
    "\1\46\1\57\53\46\1\47\6\46\1\60\6\46\1\61"+
    "\51\46\1\47\12\46\1\62\3\46\1\63\42\46\31\0"+
    "\1\64\67\0\1\65\67\0\1\66\67\0\1\67\36\0"+
    "\6\46\1\47\5\46\1\70\27\46\1\71\31\46\1\47"+
    "\16\46\1\72\50\46\1\47\5\46\1\73\61\46\1\47"+
    "\11\46\1\74\55\46\1\47\2\46\1\75\44\46\1\70"+
    "\17\46\1\47\47\46\1\76\17\46\1\47\52\46\1\61"+
    "\14\46\1\47\44\46\1\77\22\46\1\47\53\46\1\100"+
    "\5\46\4\0\1\45\72\0\1\101\60\0\6\46\1\47"+
    "\60\46\1\102\6\46\1\47\2\46\1\103\64\46\1\47"+
    "\55\46\1\104\11\46\1\47\6\46\1\105\60\46\1\47"+
    "\12\46\1\106\54\46\1\47\13\46\1\107\53\46\1\47"+
    "\35\46\1\110\31\46\1\47\57\46\1\111\7\46\1\47"+
    "\10\46\1\112\56\46\1\47\16\46\1\113\50\46\1\47"+
    "\5\46\1\114\61\46\1\47\4\46\1\115\62\46\1\47"+
    "\7\46\1\116\57\46\1\47\37\46\1\117\27\46\1\47"+
    "\14\46\1\120\52\46\1\47\42\46\1\121\24\46\1\47"+
    "\50\46\1\122\16\46\1\47\43\46\1\123\23\46\1\47"+
    "\51\46\1\124\7\46\10\0\1\125\57\0\6\46\1\47"+
    "\2\46\1\126\64\46\1\47\54\46\1\127\12\46\1\47"+
    "\2\46\1\130\64\46\1\47\7\46\1\131\57\46\1\47"+
    "\13\46\1\112\53\46\1\47\14\46\1\132\52\46\1\47"+
    "\6\46\1\127\60\46\1\47\35\46\1\126\31\46\1\47"+
    "\7\46\1\133\57\46\1\47\12\46\1\60\54\46\1\47"+
    "\16\46\1\134\50\46\1\47\35\46\1\130\31\46\1\47"+
    "\35\46\1\135\31\46\1\47\16\46\1\136\50\46\1\47"+
    "\43\46\1\137\23\46\1\47\2\46\1\135\64\46\1\47"+
    "\55\46\1\140\11\46\1\47\43\46\1\141\15\46\11\0"+
    "\1\142\56\0\6\46\1\47\10\46\1\143\56\46\1\47"+
    "\6\46\1\144\60\46\1\47\35\46\1\145\31\46\1\47"+
    "\12\46\1\146\54\46\1\47\35\46\1\147\31\46\1\47"+
    "\44\46\1\150\22\46\1\47\2\46\1\145\64\46\1\47"+
    "\2\46\1\147\56\46\4\0\23\151\14\0\25\151\6\46"+
    "\1\47\4\46\1\152\2\46\1\153\4\46\1\154\1\155"+
    "\51\46\1\47\17\46\1\112\47\46\1\47\13\46\1\156"+
    "\53\46\1\47\45\46\1\157\13\46\4\0\23\160\14\0"+
    "\25\160\6\46\1\47\11\46\1\54\55\46\1\47\6\46"+
    "\1\60\60\46\1\47\16\46\1\63\50\46\1\47\35\46"+
    "\1\161\31\46\1\47\2\46\1\161\56\46\4\0\23\162"+
    "\14\0\25\162\4\0\23\163\14\0\25\163\4\0\23\164"+
    "\14\0\25\164\4\0\23\165\14\0\25\165\4\0\23\166"+
    "\14\0\25\166\4\0\23\167\14\0\25\167\4\0\23\170"+
    "\14\0\25\170\4\0\23\171\14\0\25\171\4\0\23\172"+
    "\14\0\25\172\4\0\23\173\14\0\25\173\4\0\23\174"+
    "\14\0\25\174\4\0\23\175\14\0\25\175\4\0\23\176"+
    "\14\0\25\176\4\0\23\177\14\0\25\177\4\0\23\200"+
    "\14\0\25\200\4\0\23\201\14\0\25\201\4\0\23\202"+
    "\14\0\25\202\4\0\23\203\14\0\25\203\4\0\23\204"+
    "\14\0\25\204\4\0\23\205\14\0\25\205\4\0\23\206"+
    "\14\0\25\206\4\0\23\207\14\0\25\207\4\0\23\210"+
    "\14\0\25\210\4\0\23\211\14\0\25\211\4\0\23\212"+
    "\14\0\25\212\4\0\23\213\14\0\25\213\4\0\23\214"+
    "\14\0\25\214\4\0\23\215\14\0\25\215\4\0\23\216"+
    "\14\0\25\216";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6440];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\2\1\1\11\15\1\10\11\11\1\1\11"+
    "\1\1\13\0\1\1\2\0\4\11\1\1\21\0\1\1"+
    "\13\0\3\1\4\0\1\1\4\0\1\1\2\0\1\1"+
    "\1\0\1\1\1\0\1\1\6\0\36\1\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[142];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;


  private StringBuilder errors;

  private StringBuilder output;

  private ModuloDeErrores errorsHandler;


    /**
     * Creates a new scanner
     * There is also a java.io.InputStream version of this constructor.
     *
     * @param   in  the java.io.Reader to read input from.
   * @throws IOException 
     */
    public AnalizadorLexico(java.io.Reader in) throws IOException {
  	  this.zzReader = in;
  	  this.errors = new StringBuilder();
  	  this.output = new StringBuilder();
  	  this.errorsHandler = new ModuloDeErrores();
  	  this.next_token();
  	  this.LexicalOutput();
    }


  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
 * @throws IOException 
   */
  public AnalizadorLexico(java.io.InputStream in) throws IOException {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 156) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 4: 
          { final String str = "NUM";
		output.append( str );
          }
        case 31: break;
        case 5: 
          { final String str = "MORETHAN";
		output.append( str );
          }
        case 32: break;
        case 7: 
          { final String str = "ASSIGN";
		output.append( str );
          }
        case 33: break;
        case 6: 
          { final String str = "LESSTHAN";
		output.append( str );
          }
        case 34: break;
        case 23: 
          { final String str = "TRUE";
		output.append( str );
          }
        case 35: break;
        case 10: 
          { final String str = "TIMES";
		output.append( str );
          }
        case 36: break;
        case 11: 
          { final String str = "DIVIDES";
		output.append( str );
          }
        case 37: break;
        case 3: 
          { final String str = " ";
		output.append( str );
          }
        case 38: break;
        case 2: 
          { final String str = "\n";
		output.append( str );
          }
        case 39: break;
        case 27: 
          { final String str = "ID";
		output.append( str );
          }
        case 40: break;
        case 30: 
          { final String str = "DECLARE";
		output.append( str );
          }
        case 41: break;
        case 16: 
          { final String str = "IF";
		output.append( str );
          }
        case 42: break;
        case 21: 
          { final String str = "DO";
		output.append( str );
          }
        case 43: break;
        case 8: 
          { final String str = "PLUS";
		output.append( str );
          }
        case 44: break;
        case 15: 
          { final String str = "RCURL";
		output.append( str );
          }
        case 45: break;
        case 28: 
          { final String str = "FALSE";
		output.append( str );
          }
        case 46: break;
        case 24: 
          { final String str = "THEN";
		output.append( str );
          }
        case 47: break;
        case 22: 
          { final String str = "TYPE";output.append( str );
          }
        case 48: break;
        case 9: 
          { final String str = "MINUS";
		output.append( str );
          }
        case 49: break;
        case 29: 
          { final String str = "WHILE";
		output.append( str );
          }
        case 50: break;
        case 19: 
          { final String str = "EQUALS";
		output.append( str );
          }
        case 51: break;
        case 26: 
          { final String str = "MOVE";
		output.append( str );
          }
        case 52: break;
        case 17: 
          { final String str = "MOREEQUALS";
		output.append( str );
          }
        case 53: break;
        case 14: 
          { final String str = "LCURL";
		output.append( str );
          }
        case 54: break;
        case 13: 
          { final String str = "RBRACK";
		output.append( str );
          }
        case 55: break;
        case 20: 
          { final String str = "DIFFERENT";
		output.append( str );
          }
        case 56: break;
        case 25: 
          { final String str = "ELSE";
		output.append( str );
          }
        case 57: break;
        case 18: 
          { final String str = "LESSEQUALS";
		output.append( str );
          }
        case 58: break;
        case 12: 
          { final String str = "LBRACK";
		output.append( str );
          }
        case 59: break;
        case 1: 
          { final String str = "Invalid input: " + yytext() + "line: "+ yyline;
          errors.append(str);
          }
        case 60: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }
  private void LexicalOutput() throws IOException {

	final String outFile = "./output/lexicalAnalisis.txt";
	final BufferedWriter out = new BufferedWriter( new FileWriter( outFile ) );
	out.write( output.toString() );
	out.close();
	this.errorsHandler.lexError(errors.toString());
  }
}
