public class Words {
    private final String[] CONJUNCTION = {" and", " or", " but", " because"};
    private final String[] PROPER_NOUN = {" Fred", " Jane", " Richard Nixon", " Miss America"};
    private final String[] COMMON_NOUN = {" man", " woman", " fish", " elephant", " unicorn"};
    private final String[] DETERMINER = {" a", " the", " every", " some"};
    private final String[] ADJECTIVE = {" big", " tiny", " pretty", " bald"};
    private final String[] INTRANSITIVE_VERB = {" runs", " jumps", " talks", " sleeps"};
    private final String[] TRANSITIVE_VERB = {" loves", " hates", " sees", " knows", " looks for", " finds"};

    public static String randomItem(String[] listOfStrings) {
        return (listOfStrings[(int) (Math.random() * listOfStrings.length)]);
    }

    public String getConjunction() {
        return randomItem(CONJUNCTION);
    }

    public String getProperNoun() {
        return randomItem(PROPER_NOUN);
    }

    public String getCommonNoun() {
        return randomItem(COMMON_NOUN);
    }

    public String getDeterminer() {
        return randomItem(DETERMINER);
    }

    public String getAdjective() {
        return randomItem(ADJECTIVE);
    }

    public String getIntransitiveVerb() {
        return randomItem(INTRANSITIVE_VERB);
    }

    public String getTransitiveVerb() {
        return randomItem(TRANSITIVE_VERB);
    }

    public static boolean optional() {
        return Math.random() < 0.5;
    }

    public String sentence() {
        if (optional()) {
            return simpleSentence();
        } else {
            return simpleSentence() + getConjunction() + sentence();
        }
    }

    public String simpleSentence() {
        return nounPhrase() + verbPhrase();
    }

    public String nounPhrase() {
        if (optional()) {
            if (optional()) {
                return getProperNoun() + " who" + verbPhrase();
            } else {
                return getProperNoun();
            }
        }
        if (optional()) {
            return getDeterminer() + getAdjective() + getCommonNoun();
        } else {
            return getDeterminer() + getAdjective() + getCommonNoun() + " who" + verbPhrase();
        }
    }

    public String verbPhrase() {
        if (optional()) {
            if (optional()) {
                return getIntransitiveVerb() + " believes that" + simpleSentence();
            } else {
                return getIntransitiveVerb() + " is" + getAdjective();
            }
        } else if (optional()) {
            return getTransitiveVerb() + " believes that" + simpleSentence();
        } else {
            return getTransitiveVerb() + " is" + getAdjective();
        }
    }

}


