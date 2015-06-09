/* The following code was generated by JFlex 1.4.3 on 6/7/15 4:08 PM */

package analysis;
import java_cup.runtime.Symbol;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 6/7/15 4:08 PM from the specification file
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
    "\11\0\1\3\1\2\1\0\1\3\1\1\22\0\1\3\1\35\6\0"+
    "\1\42\1\43\1\40\1\36\1\0\1\37\1\0\1\41\1\4\11\4"+
    "\2\0\1\33\1\34\1\32\2\0\1\7\1\31\1\5\1\53\1\12"+
    "\1\61\1\31\1\6\1\60\2\31\1\54\1\55\1\62\1\56\2\31"+
    "\1\10\1\63\1\11\1\66\1\57\1\64\7\31\1\13\1\31\1\23"+
    "\1\31\1\15\1\46\1\47\1\26\1\30\1\22\1\25\2\31\1\27"+
    "\1\50\1\17\1\16\2\31\1\24\1\20\1\21\1\65\1\51\1\52"+
    "\3\31\1\44\1\14\1\45\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\1\3\1\4\11\5\1\6\1\7"+
    "\1\10\1\1\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\11\5\1\2\1\4\6\0\1\21\4\0"+
    "\1\22\1\0\1\23\1\24\1\25\1\26\1\27\17\0"+
    "\1\21\21\0\1\30\1\31\1\32\1\33\1\0\1\21"+
    "\5\0\1\34\7\0\1\21\5\0\1\35\3\0\1\36"+
    "\3\0\1\37\1\21\11\0\1\21\2\0\1\40\1\0"+
    "\1\41\1\42\1\0\1\21\1\0\2\21\1\0\27\21";

  private static int [] zzUnpackAction() {
    int [] result = new int[169];
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
    "\0\0\0\67\0\156\0\245\0\67\0\334\0\u0113\0\67"+
    "\0\u014a\0\u0181\0\u01b8\0\u01ef\0\u0226\0\u025d\0\u0294\0\u02cb"+
    "\0\u0302\0\u0339\0\u0370\0\67\0\67\0\67\0\67\0\67"+
    "\0\67\0\67\0\67\0\u03a7\0\u03de\0\u0415\0\u044c\0\u0483"+
    "\0\u04ba\0\u04f1\0\u0528\0\u055f\0\67\0\u0596\0\u05cd\0\u0604"+
    "\0\u063b\0\u0672\0\u06a9\0\u06e0\0\u0717\0\u074e\0\u0785\0\u07bc"+
    "\0\u07f3\0\67\0\u082a\0\67\0\67\0\67\0\67\0\67"+
    "\0\u0861\0\u0898\0\u08cf\0\u0906\0\u093d\0\u0974\0\u09ab\0\u09e2"+
    "\0\u0a19\0\u0a50\0\u0a87\0\u0abe\0\u0af5\0\u0b2c\0\u0b63\0\u0b9a"+
    "\0\u0bd1\0\u0c08\0\u0c3f\0\u0c76\0\u0cad\0\u0ce4\0\u0d1b\0\u0d52"+
    "\0\u0d89\0\u0dc0\0\u0df7\0\u0e2e\0\u0e65\0\u0e9c\0\u0ed3\0\u0f0a"+
    "\0\u0f41\0\67\0\67\0\67\0\67\0\u0f78\0\u0faf\0\u0fe6"+
    "\0\u101d\0\u1054\0\u108b\0\u10c2\0\67\0\u10f9\0\u1130\0\u1167"+
    "\0\u119e\0\u11d5\0\u120c\0\u1243\0\u127a\0\u12b1\0\u12e8\0\u131f"+
    "\0\u1356\0\u138d\0\67\0\u13c4\0\u13fb\0\u1432\0\67\0\u1469"+
    "\0\u14a0\0\u14d7\0\67\0\u150e\0\u1545\0\u157c\0\u15b3\0\u15ea"+
    "\0\u1621\0\u1658\0\u168f\0\u16c6\0\u16fd\0\u1734\0\u176b\0\u17a2"+
    "\0\67\0\u17d9\0\67\0\67\0\u1810\0\u1847\0\u187e\0\u01b8"+
    "\0\u18b5\0\u18ec\0\u1923\0\u195a\0\u1991\0\u19c8\0\u19ff\0\u1a36"+
    "\0\u1a6d\0\u1aa4\0\u1adb\0\u1b12\0\u1b49\0\u1b80\0\u1bb7\0\u1bee"+
    "\0\u1c25\0\u1c5c\0\u1c93\0\u1cca\0\u1d01\0\u1d38\0\u1d6f\0\u1da6"+
    "\0\67";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[169];
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
    "\1\2\1\3\1\4\1\5\1\6\1\7\3\10\1\11"+
    "\1\12\1\13\1\2\1\14\3\10\1\15\3\10\1\16"+
    "\1\17\3\10\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\1\36\1\10\1\37\1\40\1\10\1\41\2\10\1\42"+
    "\1\43\2\10\1\44\2\10\71\0\1\45\65\0\1\45"+
    "\65\0\2\46\1\0\1\46\1\6\62\46\6\0\1\47"+
    "\1\50\65\0\1\51\1\0\1\52\132\0\1\53\2\0"+
    "\1\54\13\0\7\55\1\0\1\55\70\0\1\56\4\0"+
    "\1\57\65\0\1\60\1\0\1\61\70\0\1\62\63\0"+
    "\1\63\77\0\1\64\66\0\1\65\66\0\1\66\66\0"+
    "\1\67\50\0\1\70\30\0\1\71\46\0\1\72\21\0"+
    "\1\73\33\0\1\74\72\0\1\75\56\0\1\76\43\0"+
    "\1\70\66\0\1\77\71\0\1\62\14\0\1\100\65\0"+
    "\1\101\64\0\1\46\71\0\1\102\142\0\1\103\15\0"+
    "\1\104\142\0\1\105\63\0\1\106\12\0\1\107\63\0"+
    "\7\110\1\0\1\110\71\0\1\111\67\0\1\112\115\0"+
    "\1\113\104\0\1\114\30\0\1\115\54\0\1\116\10\0"+
    "\1\117\60\0\1\120\71\0\1\121\114\0\1\122\42\0"+
    "\1\123\46\0\1\124\53\0\1\125\64\0\1\126\63\0"+
    "\1\127\72\0\1\130\16\0\1\131\70\0\1\132\136\0"+
    "\1\133\16\0\1\134\66\0\1\135\130\0\1\136\16\0"+
    "\7\137\1\0\1\137\72\0\1\140\115\0\1\132\36\0"+
    "\1\133\116\0\1\134\37\0\1\141\75\0\1\142\62\0"+
    "\1\143\112\0\1\135\46\0\1\144\106\0\1\145\46\0"+
    "\1\146\113\0\1\147\21\0\1\150\71\0\1\145\137\0"+
    "\1\151\57\0\1\152\21\0\1\153\145\0\1\154\4\0"+
    "\7\155\1\0\1\155\67\0\1\156\2\0\1\157\1\160"+
    "\3\0\1\161\1\162\107\0\1\163\42\0\1\164\130\0"+
    "\1\165\66\0\1\166\50\0\1\167\26\0\1\170\145\0"+
    "\1\171\12\0\1\163\66\0\1\167\61\0\1\172\73\0"+
    "\1\173\60\0\7\174\1\0\1\174\74\0\1\175\65\0"+
    "\1\176\62\0\1\156\2\0\1\157\4\0\1\161\1\162"+
    "\57\0\1\177\76\0\1\200\63\0\1\201\71\0\1\202"+
    "\106\0\1\173\27\0\1\203\132\0\1\204\23\0\1\205"+
    "\61\0\7\206\1\0\1\206\75\0\1\207\67\0\1\210"+
    "\63\0\1\211\63\0\1\212\117\0\1\213\40\0\1\214"+
    "\57\0\1\213\65\0\1\214\67\0\1\215\60\0\7\216"+
    "\1\0\1\216\76\0\1\211\67\0\1\217\64\0\1\177"+
    "\53\0\1\220\62\0\7\221\1\0\1\221\71\0\1\222"+
    "\53\0\7\223\1\0\1\223\102\0\1\211\42\0\7\224"+
    "\1\0\1\224\56\0\7\225\1\0\1\225\56\0\7\226"+
    "\1\0\1\226\56\0\7\227\1\0\1\227\56\0\7\230"+
    "\1\0\1\230\56\0\7\231\1\0\1\231\56\0\7\232"+
    "\1\0\1\232\56\0\7\233\1\0\1\233\56\0\7\234"+
    "\1\0\1\234\56\0\7\235\1\0\1\235\56\0\7\236"+
    "\1\0\1\236\56\0\7\237\1\0\1\237\56\0\7\240"+
    "\1\0\1\240\56\0\7\241\1\0\1\241\56\0\7\242"+
    "\1\0\1\242\56\0\7\243\1\0\1\243\56\0\7\244"+
    "\1\0\1\244\56\0\7\245\1\0\1\245\56\0\7\246"+
    "\1\0\1\246\56\0\7\247\1\0\1\247\56\0\7\250"+
    "\1\0\1\250\56\0\7\251\1\0\1\251\52\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[7645];
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
    "\1\0\1\11\2\1\1\11\2\1\1\11\13\1\10\11"+
    "\11\1\1\11\1\1\6\0\1\1\4\0\1\11\1\0"+
    "\5\11\17\0\1\1\21\0\4\11\1\0\1\1\5\0"+
    "\1\11\7\0\1\1\5\0\1\11\3\0\1\11\3\0"+
    "\1\11\1\1\11\0\1\1\2\0\1\11\1\0\2\11"+
    "\1\0\1\1\1\0\2\1\1\0\26\1\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[169];
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


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public AnalizadorLexico(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public AnalizadorLexico(java.io.InputStream in) {
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
    while (i < 150) {
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
        case 19: 
          { return new Symbol(sym.MOREEQUAL);
          }
        case 35: break;
        case 13: 
          { return new Symbol(sym.LBRACK);
          }
        case 36: break;
        case 6: 
          { return new Symbol(sym.MORETHAN);
          }
        case 37: break;
        case 3: 
          { /*Spaces are ignored*/
          }
        case 38: break;
        case 33: 
          { return new Symbol(sym.DECLARE);
          }
        case 39: break;
        case 17: 
          { return new Symbol(sym.ID);
          }
        case 40: break;
        case 29: 
          { return new Symbol(sym.FALSE);
          }
        case 41: break;
        case 21: 
          { return new Symbol(sym.EQUALS);
          }
        case 42: break;
        case 18: 
          { return new Symbol(sym.IF);
          }
        case 43: break;
        case 12: 
          { return new Symbol(sym.DIVISION);
          }
        case 44: break;
        case 8: 
          { return new Symbol(sym.ASSIGN);
          }
        case 45: break;
        case 25: 
          { return new Symbol(sym.THEN);
          }
        case 46: break;
        case 1: 
          { System.err.println("Invalid input: " + yytext() + "line: "+ yyline;
          }
        case 47: break;
        case 5: 
          { return new Symbol(sym.CHARACTER);
          }
        case 48: break;
        case 7: 
          { return new Symbol(sym.LESSTHAN);
          }
        case 49: break;
        case 9: 
          { return new Symbol(sym.PLUS);
          }
        case 50: break;
        case 32: 
          { return new Symbol(sym.TYPE);
          }
        case 51: break;
        case 24: 
          { return new Symbol(sym.CASE);
          }
        case 52: break;
        case 23: 
          { return new Symbol(sym.DO);
          }
        case 53: break;
        case 2: 
          { return new Symbol(sym.NEWLINE);
          }
        case 54: break;
        case 16: 
          { return new Symbol(sym.RCURL);
          }
        case 55: break;
        case 27: 
          { return new Symbol(sym.ELSE);
          }
        case 56: break;
        case 14: 
          { return new Symbol(sym.RBRACK);
          }
        case 57: break;
        case 20: 
          { return new Symbol(sym.LESSEQUALS);
          }
        case 58: break;
        case 10: 
          { return new Symbol(sym.MINUS);
          }
        case 59: break;
        case 4: 
          { return new Symbol(sym.NUM);
          }
        case 60: break;
        case 11: 
          { return new Symbol(sym.TIMES);
          }
        case 61: break;
        case 30: 
          { return new Symbol(sym.WHILE);
          }
        case 62: break;
        case 34: 
          { return new Symbol(sym.DEFAULT);
          }
        case 63: break;
        case 31: 
          { return new Symbol(sym.EVALUE);
          }
        case 64: break;
        case 22: 
          { return new Symbol(sym.DIFFERENT);
          }
        case 65: break;
        case 28: 
          { return new Symbol(sym.MOVE);
          }
        case 66: break;
        case 15: 
          { return new Symbol(sym.LCURL);
          }
        case 67: break;
        case 26: 
          { return new Symbol(sym.TRUE);
          }
        case 68: break;
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


}
