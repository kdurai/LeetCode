package com.leetcode.medium.dec201914;

import java.util.LinkedList;
import java.util.Queue;

public class NumMatchingSubseq {
	
	static class Item {
		String word;
		int index;
		
		public Item(String word, int index) {
			this.word = word;
			this.index = index;
		}
		
	}

	public static void main(String[] args) {

		/*
		 * String S =
		 * "ricogwqznwxxcpueelcobbbkuvxxrvgyehsudccpsnuxpcqobtvwkuvsubiidjtccoqvuahijyefbpqhbejuisksutsowhufsygtwteiqyligsnbqglqblhpdzzeurtdohdcbjvzgjwylmmoiundjscnlhbrhookmioxqighkxfugpeekgtdofwzemelpyjsdeeppapjoliqlhbrbghqjezzaxuwyrbczodtrhsvnaxhcjiyiphbglyolnswlvtlbmkrsurrcsgdzutwgjofowhryrubnxkahocqjzwwagqidjhwbunvlchojtbvnzdzqpvrazfcxtvhkruvuturdicnucvndigovkzrqiyastqpmfmuouycodvsyjajekhvyjyrydhxkdhffyytldcdlxqbaszbuxsacqwqnhrewhagldzhryzdmmrwnxhaqfezeeabuacyswollycgiowuuudrgzmwnxaezuqlsfvchjfloczlwbefksxsbanrektvibbwxnokzkhndmdhweyeycamjeplecewpnpbshhidnzwopdjuwbecarkgapyjfgmanuavzrxricbgagblomyseyvoeurekqjyljosvbneofjzxtaizjypbcxnbfeibrfjwyjqrisuybfxpvqywqjdlyznmojdhbeomyjqptltpugzceyzenflfnhrptuugyfsghluythksqhmxlmggtcbdddeoincygycdpehteiugqbptyqbvokpwovbnplshnzafunqglnpjvwddvdlmjjyzmwwxzjckmaptilrbfpjxiarmwalhbdjiwbaknvcqovwcqiekzfskpbhgxpyomekqvzpqyirelpadooxjhsyxjkfqavbaoqqvvknqryhotjritrkvdveyapjfsfzenfpuazdrfdofhudqbfnzxnvpluwicurrtshyvevkriudayyysepzqfgqwhgobwyhxltligahroyshfndydvffd";
		 * String[] words = { "iowuuudrgzmw", "azfcxtvhkruvuturdicnucvndigovkzrq",
		 * "ylmmo", "maptilrbfpjxiarmwalhbd",
		 * "oqvuahijyefbpqhbejuisksutsowhufsygtwteiqyligsnbqgl",
		 * "ytldcdlxqbaszbuxsacqwqnhrewhagldzhr", "zeeab", "cqie",
		 * "pvrazfcxtvhkruvuturdicnucvndigovkzrqiya",
		 * "zxnvpluwicurrtshyvevkriudayyysepzq", "wyhxltligahroyshfn",
		 * "nhrewhagldzhryzdmmrwn", "yqbvokpwovbnplshnzafunqglnpjvwddvdlmjjyzmw",
		 * "nhrptuugyfsghluythksqhmxlmggtcbdd",
		 * "yligsnbqglqblhpdzzeurtdohdcbjvzgjwylmmoiundjsc",
		 * "zdrfdofhudqbfnzxnvpluwicurrtshyvevkriudayyysepzq",
		 * "ncygycdpehteiugqbptyqbvokpwovbnplshnzafun",
		 * "gdzutwgjofowhryrubnxkahocqjzww", "eppapjoliqlhbrbgh",
		 * "qwhgobwyhxltligahroys", "dzutwgjofowhryrubnxkah",
		 * "rydhxkdhffyytldcdlxqbaszbuxs",
		 * "tyqbvokpwovbnplshnzafunqglnpjvwddvdlmjjyzmwwxzjc",
		 * "khvyjyrydhxkdhffyytldcdlxqbasz",
		 * "jajekhvyjyrydhxkdhffyytldcdlxqbaszbuxsacqwqn", "ppapjoliqlhbrbghq",
		 * "zmwwxzjckmaptilrbfpjxiarm", "nxkahocqjzwwagqidjhwbunvlchoj",
		 * "ybfxpvqywqjdlyznmojdhbeomyjqptltp", "udrgzmwnxae", "nqglnpjvwddvdlmjjyzmww",
		 * "swlvtlbmkrsurrcsgdzutwgjofowhryrubn", "hudqbfnzxnvpluwicurr",
		 * "xaezuqlsfvchjf", "tvibbwxnokzkhndmdhweyeycamjeplec",
		 * "olnswlvtlbmkrsurrcsgdzu", "qiyastqpmfmuouycodvsyjajekhvyjyrydhxkdhffyyt",
		 * "eiqyligsnbqglqblhpdzzeurtdohdcbjvzgjwyl",
		 * "cgiowuuudrgzmwnxaezuqlsfvchjflocz", "rxric",
		 * "cygycdpehteiugqbptyqbvokpwovbnplshnzaf", "g", "surrcsgd",
		 * "yzenflfnhrptuugyfsghluythksqh", "gdzutwgjofowhryrubnxkahocqjzwwagqid",
		 * "ddeoincygycdpeh", "yznmojdhbeomyjqptltpugzceyzenflfnhrptuug", "ejuisks",
		 * "teiqyligsnbqglqblhpdzzeurtdohdcbjvzgjwylmmoi",
		 * "mrwnxhaqfezeeabuacyswollycgio",
		 * "qfskkpfakjretogrokmxemjjbvgmmqrfdxlkfvycwalbdeumav",
		 * "wjgjhlrpvhqozvvkifhftnfqcfjmmzhtxsoqbeduqmnpvimagq",
		 * "ibxhtobuolmllbasaxlanjgalgmbjuxmqpadllryaobcucdeqc",
		 * "ydlddogzvzttizzzjohfsenatvbpngarutztgdqczkzoenbxzv",
		 * "rmsakibpprdrttycxglfgtjlifznnnlkgjqseguijfctrcahbb",
		 * "pqquuarnoybphojyoyizhuyjfgwdlzcmkdbdqzatgmabhnpuyh",
		 * "akposmzwykwrenlcrqwrrvsfqxzohrramdajwzlseguupjfzvd",
		 * "vyldyqpvmnoemzeyxslcoysqfpvvotenkmehqvopynllvwhxzr",
		 * "ysyskgrbolixwmffygycvgewxqnxvjsfefpmxrtsqsvpowoctw",
		 * "oqjgumitldivceezxgoiwjgozfqcnkergctffspdxdbnmvjago",
		 * "bpfgqhlkvevfazcmpdqakonkudniuobhqzypqlyocjdngltywn",
		 * "ttucplgotbiceepzfxdebvluioeeitzmesmoxliuwqsftfmvlg",
		 * "xhkklcwblyjmdyhfscmeffmmerxdioseybombzxjatkkltrvzq",
		 * "qkvvbrgbzzfhzizulssaxupyqwniqradvkjivedckjrinrlxgi",
		 * "itjudnlqncbspswkbcwldkwujlshwsgziontsobirsvskmjbrq",
		 * "nmfgxfeqgqefxqivxtdrxeelsucufkhivijmzgioxioosmdpwx",
		 * "ihygxkykuczvyokuveuchermxceexajilpkcxjjnwmdbwnxccl",
		 * "etvcfbmadfxlprevjjnojxwonnnwjnamgrfwohgyhievupsdqd",
		 * "ngskodiaxeswtqvjaqyulpedaqcchcuktfjlzyvddfeblnczmh",
		 * "vnmntdvhaxqltluzwwwwrbpqwahebgtmhivtkadczpzabgcjzx",
		 * "yjqqdvoxxxjbrccoaqqspqlsnxcnderaewsaqpkigtiqoqopth",
		 * "wdytqvztzbdzffllbxexxughdvetajclynypnzaokqizfxqrjl",
		 * "yvvwkphuzosvvntckxkmvuflrubigexkivyzzaimkxvqitpixo",
		 * "lkdgtxmbgsenzmrlccmsunaezbausnsszryztfhjtezssttmsr",
		 * "idyybesughzyzfdiibylnkkdeatqjjqqjbertrcactapbcarzb",
		 * "ujiajnirancrfdvrfardygbcnzkqsvujkhcegdfibtcuxzbpds",
		 * "jjtkmalhmrknaasskjnixzwjgvusbozslrribgazdhaylaxobj",
		 * "nizuzttgartfxiwcsqchizlxvvnebqdtkmghtcyzjmgyzszwgi",
		 * "egtvislckyltpfogtvfbtxbsssuwvjcduxjnjuvnqyiykvmrxl",
		 * "ozvzwalcvaobxbicbwjrububyxlmfcokdxcrkvuehbnokkzala",
		 * "azhukctuheiwghkalboxfnuofwopsrutamthzyzlzkrlsefwcz",
		 * "yhvjjzsxlescylsnvmcxzcrrzgfhbsdsvdfcykwifzjcjjbmmu",
		 * "tspdebnuhrgnmhhuplbzvpkkhfpeilbwkkbgfjiuwrdmkftphk",
		 * "jvnbeqzaxecwxspuxhrngmvnkvulmgobvsnqyxdplrnnwfhfqq",
		 * "bcbkgwpfmmqwmzjgmflichzhrjdjxbcescfijfztpxpxvbzjch",
		 * "bdrkibtxygyicjcfnzigghdekmgoybvfwshxqnjlctcdkiunob",
		 * "koctqrqvfftflwsvssnokdotgtxalgegscyeotcrvyywmzescq",
		 * "boigqjvosgxpsnklxdjaxtrhqlyvanuvnpldmoknmzugnubfoa",
		 * "jjtxbxyazxldpnbxzgslgguvgyevyliywihuqottxuyowrwfar",
		 * "zqsacrwcysmkfbpzxoaszgqqsvqglnblmxhxtjqmnectaxntvb",
		 * "izcakfitdhgujdborjuhtwubqcoppsgkqtqoqyswjfldsbfcct",
		 * "rroiqffqzenlerchkvmjsbmoybisjafcdzgeppyhojoggdlpzq",
		 * "xwjqfobmmqomhczwufwlesolvmbtvpdxejzslxrvnijhvevxmc",
		 * "ccrubahioyaxuwzloyhqyluwoknxnydbedenrccljoydfxwaxy",
		 * "jjoeiuncnvixvhhynaxbkmlurwxcpukredieqlilgkupminjaj",
		 * "pdbsbjnrqzrbmewmdkqqhcpzielskcazuliiatmvhcaksrusae",
		 * "nizbnxpqbzsihakkadsbtgxovyuebgtzvrvbowxllkzevktkuu",
		 * "hklskdbopqjwdrefpgoxaoxzevpdaiubejuaxxbrhzbamdznrr",
		 * "uccnuegvmkqtagudujuildlwefbyoywypakjrhiibrxdmsspjl",
		 * "awinuyoppufjxgqvcddleqdhbkmolxqyvsqprnwcoehpturicf" };
		 */

		String S = "abcde";
		String[] words = {"a","acd"};
		System.out.println(numMatchingSubseq(S, words));
	}

	public static int numMatchingSubseq(String S, String[] words) {

		Queue<Item>[] dict = new Queue[26];
		
		for(int i = 0; i < dict.length; i++)
			dict[i] = new LinkedList<>();
		
		for(String word: words) 
			if(word.length() > 0)
				dict[word.charAt(0)-'a'].add(new Item(word, 0));

		int count = 0;
		
		for(char c: S.toCharArray()) {
			Queue<Item> queue = dict[c-'a'];
			int size = queue.size();
			
			for(int i = 0; i < size; i++)
			{
				Item item = queue.remove();
				item.index++;
				
				if(item.index == item.word.length())
					count++;
				else
					dict[item.word.charAt(item.index) - 'a'].add(item);
			}
		}
		
		return count;
	}
}
