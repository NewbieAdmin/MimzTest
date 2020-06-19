/*

package newbie.base;

public class Breaker {

// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space
// Source File Name: Breaker.java
package org.xhtmlrenderer.layout;
import java.text.BreakIterator;
import org.xhtmlrenderer.css.constants.IdentValue;
import org.xhtmlrenderer.css.style.CalculatedStyle;
import org.xhtmlrenderer.extend.TextRenderer;

    // Referenced classes of package org.xhtmlrenderer.layout:
// LineBreakContext, LayoutContext
    public class Breaker {
        public Breaker() {
        }

        public static void breakFirstLetter(LayoutContext c, LineBreakContext context, int avail, CalculatedStyle style) {
            org.xhtmlrenderer.render.FSFont font = style.getFSFont(c);
            context.setEnd(getFirstLetterEnd(context.getMaster(), context.getStart()));
            context.setWidth(c.getTextRenderer().getWidth(c.getFontContext(), font, context.getCalculatedSubstring()));
            if (context.getWidth() > avail) {
                context.setNeedsNewLine(true);
                context.setUnbreakable(true);
            }
        }

        private static int getFirstLetterEnd(String text, int start) {
            int i = start;
            do {
                if (i >= text.length())
                    break;
                char c = text.charAt(i);
                int type = Character.getType(c);
                if (type != 21 && type != 22 && type != 29 && type != 30 && type != 24)
                    break;
                i++;
            } while (true);
            if (i < text.length())
                i++;
            return i;
        }

        public static void breakText(LayoutContext c, LineBreakContext context, int avail, CalculatedStyle style) {
            org.xhtmlrenderer.render.FSFont font = style.getFSFont(c);
            IdentValue whitespace = style.getWhitespace();
            if (whitespace == IdentValue.NOWRAP) {
                context.setEnd(context.getLast());
                context.setWidth(c.getTextRenderer().getWidth(c.getFontContext(), font, context.getCalculatedSubstring()));
                return;
            }
            if (whitespace == IdentValue.PRE || whitespace == IdentValue.PRE_WRAP || whitespace == IdentValue.PRE_LINE) {
                int n = context.getStartSubstring().indexOf("\n");
                if (n > -1) {
                    context.setEnd(context.getStart() + n + 1);
                    context.setWidth(c.getTextRenderer().getWidth(c.getFontContext(), font, context.getCalculatedSubstring()));
                    context.setNeedsNewLine(true);
                    context.setEndsOnNL(true);
                } else if (whitespace == IdentValue.PRE) {
                    context.setEnd(context.getLast());
                    context.setWidth(c.getTextRenderer().getWidth(c.getFontContext(), font, context.getCalculatedSubstring()));
                }
            }
            if (whitespace == IdentValue.PRE || context.isNeedsNewLine() && context.getWidth() <= avail)
                return;
            context.setEndsOnNL(false);
            String currentString = context.getStartSubstring();
            int left = 0;
            int right = getStrRight(currentString, left + 1);
            int lastWrap = 0;
            int graphicsLength = 0;
            int lastGraphicsLength = 0;
            for (; right > 0 && graphicsLength <= avail; right = getStrRight(currentString, left + 1)) {
                lastGraphicsLength = graphicsLength;
                graphicsLength += c.getTextRenderer().getWidth(c.getFontContext(), font, currentString.substring(left, right));
                lastWrap = left;
                left = right;
            }
            if (graphicsLength <= avail) {
                lastWrap = left;
                lastGraphicsLength = graphicsLength;
                graphicsLength += c.getTextRenderer().getWidth(c.getFontContext(), font, currentString.substring(left));
            }
            if (graphicsLength <= avail) {
                context.setWidth(graphicsLength);
                context.setEnd(context.getMaster().length());
                return;
            }
            context.setNeedsNewLine(true);
            if (lastWrap != 0) {
                context.setEnd(context.getStart() + lastWrap);
                context.setWidth(lastGraphicsLength);
            } else {
                if (left == 0)
                    left = currentString.length();
                context.setEnd(context.getStart() + left);
                context.setUnbreakable(true);
                if (left == currentString.length())
                    context.setWidth(c.getTextRenderer().getWidth(c.getFontContext(), font, context.getCalculatedSubstring()));
                else
                    context.setWidth(graphicsLength);
            }
        }

        public static BreakIterator getWordStream(String s) {
            BreakIterator i = BreakIterator.getWordInstance();
            i.setText(s);
            return i;
        }


*/
/**
         * 判断是否是中文
         *
         * @param c
         * @return
         *//*


        private static boolean isChinses(char c) {
            Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
            if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                    || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                    || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                    || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                    || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                    || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
                return true;
            }
            return false;
        }


        */
/**
         * 替换原先本类中所以获取right的方法
         * int right = getStrRight(currentString,left+1);
         *
         * @param s
         * @param left
         * @return
         *//*


        private static int getStrRight(String s, int left) {
            if (left >= s.length())
                return -1;
            char[] ch = s.toCharArray();
            for (int i = left; i < ch.length; i++) {
                if (isChinses(ch[i]) || '\0' == ch[i]) {
                    return i == 0 ? i + 1 : i;
                }
            }
            return -1;
        }
    }
}

*/
