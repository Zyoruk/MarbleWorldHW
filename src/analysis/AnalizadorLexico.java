/* The following code was generated by JFlex 1.4.3 on 6/12/15 4:41 PM */

package analysis;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import constants.Constants;
import symbolTable.SymbolTable;
import Datastructs.SimpleList.SimpleList;
import errorHandler.ModuloDeErrores;
import java_cup.runtime.Symbol;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 6/12/15 4:41 PM from the specification file
 * <tt>/home/zyoruk/Projects/workspace/Compi/MarbleWorldHW/src/analysis/AnalisisLexico.flex</tt>
 */
public class AnalizadorLexico implements java_cup.runtime.Scanner {
	SimpleList <String> lexemes;
	SimpleList <String> types;
	SimpleList <String> values;
	SimpleList <String> lines;
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
			"\11\0\1\3\1\2\1\0\1\3\1\1\22\0\1\3\1\30\6\0"+
					"\1\35\1\36\1\33\1\31\1\0\1\32\1\0\1\34\1\4\11\24"+
					"\2\0\1\26\1\27\1\25\2\0\1\51\1\6\1\47\1\23\1\46"+
					"\1\57\1\6\1\61\1\56\2\6\1\50\1\53\1\62\1\54\2\6"+
					"\1\52\1\63\1\60\1\66\1\55\1\64\3\6\4\0\1\5\1\0"+
					"\1\15\1\6\1\7\1\41\1\42\1\20\1\22\1\14\1\17\2\6"+
					"\1\21\1\43\1\11\1\10\2\6\1\16\1\12\1\13\1\65\1\44"+
					"\1\45\3\6\1\37\1\0\1\40\uff82\0";

	/** 
	 * Translates characters to character classes
	 */
	private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

	/** 
	 * Translates DFA states to action switch labels.
	 */
	private static final int [] ZZ_ACTION = zzUnpackAction();

	private static final String ZZ_ACTION_PACKED_0 =
			"\1\0\1\1\2\2\1\3\1\4\7\1\1\5\1\6"+
					"\1\7\1\1\1\10\1\11\1\12\1\13\1\14\1\15"+
					"\1\16\1\17\12\1\1\2\1\4\1\20\6\0\1\21"+
					"\2\0\1\22\1\0\1\23\1\24\1\25\1\26\1\27"+
					"\12\0\1\20\5\0\1\30\15\0\1\20\2\0\1\31"+
					"\1\32\3\0\1\33\1\34\3\0\1\20\2\0\1\35"+
					"\2\0\1\36\1\20\6\0\1\20\1\37\32\20";

	private static int [] zzUnpackAction() {
		int [] result = new int[139];
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
			"\0\0\0\67\0\156\0\245\0\67\0\334\0\u0113\0\u014a"+
					"\0\u0181\0\u01b8\0\u01ef\0\u0226\0\u025d\0\u0294\0\u02cb\0\u0302"+
					"\0\u0339\0\67\0\67\0\67\0\67\0\67\0\67\0\67"+
					"\0\67\0\u0370\0\u03a7\0\u03de\0\u0415\0\u044c\0\u0483\0\u04ba"+
					"\0\u04f1\0\u0528\0\u055f\0\67\0\u0596\0\u05cd\0\u0604\0\u063b"+
					"\0\u0672\0\u06a9\0\u06e0\0\u0717\0\67\0\u074e\0\u0785\0\67"+
					"\0\u07bc\0\67\0\67\0\67\0\67\0\67\0\u07f3\0\u082a"+
					"\0\u0861\0\u0898\0\u08cf\0\u0906\0\u093d\0\u0974\0\u09ab\0\u09e2"+
					"\0\u0a19\0\u0a50\0\u0a87\0\u0abe\0\u0af5\0\u0b2c\0\67\0\u0b63"+
					"\0\u0b9a\0\u0bd1\0\u0c08\0\u0c3f\0\u0c76\0\u0cad\0\u0ce4\0\u0d1b"+
					"\0\u0d52\0\u0d89\0\u0dc0\0\u0df7\0\u0e2e\0\u0e65\0\u0e9c\0\67"+
					"\0\67\0\u0ed3\0\u0f0a\0\u0f41\0\67\0\67\0\u0f78\0\u0faf"+
					"\0\u0fe6\0\u101d\0\u1054\0\u108b\0\67\0\u10c2\0\u10f9\0\67"+
					"\0\u1130\0\u1167\0\u0181\0\u119e\0\u11d5\0\u120c\0\u1243\0\u127a"+
					"\0\67\0\u12b1\0\u12e8\0\u131f\0\u1356\0\u138d\0\u13c4\0\u13fb"+
					"\0\u1432\0\u1469\0\u14a0\0\u14d7\0\u150e\0\u1545\0\u157c\0\u15b3"+
					"\0\u15ea\0\u1621\0\u1658\0\u168f\0\u16c6\0\u16fd\0\u1734\0\u176b"+
					"\0\u17a2\0\u17d9\0\67";

	private static int [] zzUnpackRowMap() {
		int [] result = new int[139];
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
			"\1\2\1\3\1\4\1\5\1\6\1\7\1\2\1\10"+
					"\2\2\1\11\1\12\3\2\1\13\1\14\2\2\1\15"+
					"\1\6\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
					"\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
					"\1\2\1\35\1\36\4\2\1\37\2\2\1\40\1\41"+
					"\1\42\3\2\1\43\2\2\71\0\1\44\65\0\1\44"+
					"\65\0\2\45\1\0\1\45\1\6\17\45\1\6\42\45"+
					"\6\0\16\46\15\0\26\46\10\0\1\47\3\0\1\50"+
					"\65\0\1\51\67\0\1\52\1\0\1\53\61\0\1\54"+
					"\6\0\1\55\63\0\1\56\3\0\1\57\71\0\1\60"+
					"\21\0\1\61\5\0\1\62\41\0\1\63\66\0\1\64"+
					"\66\0\1\65\66\0\1\66\47\0\1\62\31\0\1\67"+
					"\45\0\1\70\55\0\1\71\72\0\1\72\122\0\1\73"+
					"\72\0\1\74\71\0\1\55\60\0\1\75\67\0\1\76"+
					"\6\0\1\77\66\0\1\100\11\0\1\45\17\0\1\45"+
					"\46\0\21\101\14\0\26\101\11\0\1\102\72\0\1\103"+
					"\67\0\1\104\112\0\1\105\111\0\1\106\14\0\1\107"+
					"\74\0\1\110\55\0\1\111\125\0\1\112\26\0\1\113"+
					"\71\0\1\114\120\0\1\115\41\0\1\116\132\0\1\117"+
					"\60\0\1\120\61\0\1\121\104\0\1\122\46\0\1\123"+
					"\76\0\1\124\14\0\21\125\14\0\26\125\12\0\1\126"+
					"\72\0\1\107\67\0\1\127\60\0\1\130\117\0\1\131"+
					"\36\0\1\132\71\0\1\54\121\0\1\133\37\0\1\134"+
					"\107\0\1\135\66\0\1\136\45\0\1\137\113\0\1\135"+
					"\66\0\1\136\103\0\1\140\51\0\1\131\102\0\1\130"+
					"\54\0\1\141\22\0\21\142\14\0\26\142\13\0\1\143"+
					"\64\0\1\144\117\0\1\145\75\0\1\146\32\0\1\147"+
					"\113\0\1\150\72\0\1\145\66\0\1\150\24\0\21\151"+
					"\14\0\26\151\7\0\1\152\2\0\1\153\4\0\1\154"+
					"\1\155\70\0\1\107\116\0\1\156\32\0\1\157\54\0"+
					"\21\160\14\0\26\160\14\0\1\50\63\0\1\54\76\0"+
					"\1\57\113\0\1\161\62\0\1\161\30\0\21\162\14\0"+
					"\26\162\4\0\21\163\14\0\26\163\4\0\21\164\14\0"+
					"\26\164\4\0\21\165\14\0\26\165\4\0\21\166\14\0"+
					"\26\166\4\0\21\167\14\0\26\167\4\0\21\170\14\0"+
					"\26\170\4\0\21\171\14\0\26\171\4\0\21\172\14\0"+
					"\26\172\4\0\21\173\14\0\26\173\4\0\21\174\14\0"+
					"\26\174\4\0\21\175\14\0\26\175\4\0\21\176\14\0"+
					"\26\176\4\0\21\177\14\0\26\177\4\0\21\200\14\0"+
					"\26\200\4\0\21\201\14\0\26\201\4\0\21\202\14\0"+
					"\26\202\4\0\21\203\14\0\26\203\4\0\21\204\14\0"+
					"\26\204\4\0\21\205\14\0\26\205\4\0\21\206\14\0"+
					"\26\206\4\0\21\207\14\0\26\207\4\0\21\210\14\0"+
					"\26\210\4\0\21\211\14\0\26\211\4\0\21\212\14\0"+
					"\26\212\4\0\21\213\14\0\26\213";

	private static int [] zzUnpackTrans() {
		int [] result = new int[6160];
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
			"\1\0\1\11\2\1\1\11\14\1\10\11\12\1\1\11"+
					"\2\1\6\0\1\11\2\0\1\11\1\0\5\11\12\0"+
					"\1\1\5\0\1\11\15\0\1\1\2\0\2\11\3\0"+
					"\2\11\3\0\1\1\2\0\1\11\2\0\1\11\1\1"+
					"\6\0\1\1\1\11\31\1\1\11";

	private static int [] zzUnpackAttribute() {
		int [] result = new int[139];
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
	public AnalizadorLexico(java.io.Reader in,ModuloDeErrores pErrores) throws IOException {
		this.zzReader = in;
		this.errors = new StringBuilder();
		this.output = new StringBuilder();
		this.errorsHandler = pErrores;
		this.lexemes = new SimpleList<String>();
		this.types = new SimpleList<String>();
		this.values = new SimpleList<String>();
		this.lines = new SimpleList<String>();
	}
	/**
	 * Creates a new scanner.
	 * There is also java.io.Reader version of this constructor.
	 *
	 * @param   in  the java.io.Inputstream to read input from.
	 * @throws IOException 
	 */
	public AnalizadorLexico(java.io.InputStream in,ModuloDeErrores pErrores) throws IOException {
		this(new java.io.InputStreamReader(in),pErrores);
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
		while (i < 152) {
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
			this.LexicalOutput();
			this.buildSymbolTable();
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
			Constants K = new Constants();

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
			{
				output.append( yytext() );
				return new Symbol(sym.NUM, yychar,yyline,new String(yytext()));
			}
			case 32: break;
			case 5: 
			{ 
				final String str = K._MORETHAN_;
				output.append( str );
				return new Symbol(sym.MORETHAN, yychar,yyline);
			}
			case 33: break;
			case 7: 
			{ 
				final String str = K._ASSIGN_;
				output.append( str );
				return new Symbol(sym.ASSIGN, yychar,yyline);
			}
			case 34: break;
			case 6: 
			{ 
				final String str = K._LESSTHAN_;
				output.append( str );
				return new Symbol(sym.LESSTHAN, yychar,yyline);
			}
			case 35: break;
			case 26: 
			{ 
				final String str = K._TRUE_;
				output.append( str );
				return new Symbol(sym.TRUE, yychar,yyline);
			}
			case 36: break;
			case 10: 
			{ 
				final String str = K._FALSE_;
				output.append( str );
				return new Symbol(sym.TIMES, yychar,yyline);
			}
			case 37: break;
			case 11: 
			{ 
				final String str = K._DIVISION_;
				output.append( str );
				return new Symbol(sym.DIVISION, yychar,yyline);
			}
			case 38: break;
			case 3: 
			{ 
				final String str = K._SPACE_;
				output.append( str );
			}
			case 39: break;
			case 2: 
			{ 
				final String str = K._NEWLINE_CHAR_;
				output.append( str );
				return new Symbol(sym.NEWLINE, yychar,yyline);
			}
			case 40: break;
			case 16: 
			{ 
				output.append( yytext() );
				if (this.lexemes.length()!=0){
					if (!this.values.exists(yytext())){
						this.values.append(yytext());
						this.lexemes.append(K._ID_);
						this.lines.append(Integer.toString(yyline));
					}
				}else{
					this.values.append(yytext());
					this.lexemes.append(K._ID_);
					this.lines.append(Integer.toString(yyline));
				}
				return new Symbol(sym.ID, yychar,yyline,new String(yytext()));
			}
			case 41: break;
			case 31: 
			{ 
				final String str = K._DECLARE_;
				output.append( str );
				return new Symbol(sym.DECLARE, yychar,yyline);
			}
			case 42: break;
			case 17: 
			{ 
				final String str = K._IF_;
				output.append( str );
				return new Symbol(sym.IF, yychar,yyline);
			}
			case 43: break;
			case 19: 
			{ 
				final String str = K._DO_;
				output.append( str );
				return new Symbol(sym.DO, yychar,yyline);
			}
			case 44: break;
			case 8: 
			{ 
				final String str = K._PLUS_;
				output.append( str );
				return new Symbol(sym.PLUS, yychar,yyline);
			}
			case 45: break;
			case 15: 
			{ 
				final String str = K._RCURL_;
				output.append( str );
				return new Symbol(sym.RCURL, yychar,yyline);
			}
			case 46: break;
			case 18: 
			{
				output.append(yytext());
				return new Symbol(sym.DOOR, yychar,yyline);
			}
			case 47: break;
			case 29: 
			{ 
				final String str = K._FALSE_;
				output.append( str );
				return new Symbol(sym.FALSE, yychar,yyline);
			}
			case 48: break;
			case 25: 
			{ 
				final String str = K._THEN_;
				output.append( str );
				return new Symbol(sym.THEN, yychar,yyline);
			}
			case 49: break;
			case 9: 
			{ 
				final String str = K._MINUS_;
				output.append( str );
				return new Symbol(sym.MINUS, yychar,yyline);
			}
			case 50: break;
			case 30: 
			{ 
				final String str = K._WHILE_;
				output.append( str );
				return new Symbol(sym.WHILE, yychar,yyline);
			}
			case 51: break;
			case 22: 
			{ 
				final String str = K._EQUALS_;
				output.append( str );
				return new Symbol(sym.EQUALS, yychar,yyline);
			}
			case 52: break;
			case 28: 
			{ 
				final String str = K._MOVE_;
				output.append( str );
				return new Symbol(sym.MOVE, yychar,yyline);
			}
			case 53: break;
			case 20: 
			{ 
				final String str = K._MOREEQUAL_;
				output.append( str );
				return new Symbol(sym.MOREEQUAL, yychar,yyline);
			}
			case 54: break;
			case 14: 
			{ 
				final String str = K._LCURL_;
				output.append( str );
				return new Symbol(sym.LCURL, yychar,yyline);
			}
			case 55: break;
			case 24: 
			{ 
				final String str = K._TYPE_;
				output.append( str );
				this.types.append(yytext());
				return new Symbol(sym.TYPE, yychar,yyline);
			}
			case 56: break;
			case 13: 
			{ 
				final String str = K._RBRACK_;
				output.append( str );
				return new Symbol(sym.RBRACK, yychar,yyline);
			}
			case 57: break;
			case 23: 
			{ 
				final String str = K._DIFFERENT_;
				output.append( str );
				return new Symbol(sym.DIFFERENT, yychar,yyline);
			}
			case 58: break;
			case 27: 
			{ 
				final String str = K._ELSE_;
				output.append( str );
				return new Symbol(sym.ELSE, yychar,yyline);
			}
			case 59: break;
			case 21: 
			{ 
				final String str = K._LESSEQUALS_;
				output.append( str );
				return new Symbol(sym.LESSEQUALS, yychar,yyline);
			}
			case 60: break;
			case 12: 
			{ 
				final String str = K._LBRACK_;
				output.append( str );
				return new Symbol(sym.LBRACK, yychar,yyline);
			}
			case 61: break;
			case 1: 
			{ 
				final String str = "Invalid input: " + yytext() + "line: "+ yyline;
				errors = new StringBuilder();
				errors.append(str);
				this.lexErrors();
			}
			case 62: break;
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
		Constants K = new Constants();
		final BufferedWriter out = new BufferedWriter( new FileWriter( K._LEX_OUTPUT ) );
		out.write( output.toString() );
		out.close();
	}
	private SymbolTable st;
	private void buildSymbolTable() throws IOException{
		st = new SymbolTable(this.lexemes,this.values,this.types,this.lines);
		st.outputTable();
	}
	private void lexErrors() throws IOException{
		this.errorsHandler.lexError(errors.toString());
		this.buildSymbolTable();
	}
	public SymbolTable getSymbolTable(){
		return this.st;
	}
}
