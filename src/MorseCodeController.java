import javax.sound.sampled.*;
import java.util.HashMap;

// this class will handle the logic for GUI
public class MorseCodeController {
    // we'll use a hashmap to translate user input into morse code
    // a hashmap is a date structure that stores key/value pairs
    // is this case, we'll use the latter as the key and the corresponding more code as the value
    // this way, we can easily look up the morse code for any given letter by using the letter as the key

    // here I am declaring a hashmap to have a key of type "Character" with a value of type "String"
    private HashMap<Character, String> morseCodeMap;

    public MorseCodeController() {
        morseCodeMap = new HashMap<>();

        // uppercase English
        morseCodeMap.put('A', ".-");
        morseCodeMap.put('B', "-...");
        morseCodeMap.put('C', "-.-.");
        morseCodeMap.put('D', "-..");
        morseCodeMap.put('E', ".");
        morseCodeMap.put('F', "..-.");
        morseCodeMap.put('G', "--.");
        morseCodeMap.put('H', "....");
        morseCodeMap.put('I', "..");
        morseCodeMap.put('J', ".---");
        morseCodeMap.put('K', "-.-");
        morseCodeMap.put('L', ".-..");
        morseCodeMap.put('M', "--");
        morseCodeMap.put('N', "-.");
        morseCodeMap.put('O', "---");
        morseCodeMap.put('P', ".--.");
        morseCodeMap.put('Q', "--.-");
        morseCodeMap.put('R', ".-.");
        morseCodeMap.put('S', "...");
        morseCodeMap.put('T', "-");
        morseCodeMap.put('U', "..-");
        morseCodeMap.put('V', "...-");
        morseCodeMap.put('W', ".--");
        morseCodeMap.put('Y', "-..-");
        morseCodeMap.put('X', "-.--");
        morseCodeMap.put('Z', "--..");

        // uppercase Rus
        morseCodeMap.put('А', ".-");
        morseCodeMap.put('Б', "-...");
        morseCodeMap.put('Ц', "-.-.");
        morseCodeMap.put('Д', "-..");
        morseCodeMap.put('Е', ".");
        morseCodeMap.put('Ф', "..-.");
        morseCodeMap.put('Г', "--.");
        morseCodeMap.put('Х', "....");
        morseCodeMap.put('И', "..");
        morseCodeMap.put('Й', ".---");
        morseCodeMap.put('К', "-.-");
        morseCodeMap.put('Л', ".-..");
        morseCodeMap.put('М', "--");
        morseCodeMap.put('Н', "-.");
        morseCodeMap.put('О', "---");
        morseCodeMap.put('П', ".--.");
        morseCodeMap.put('Щ', "--.-");
        morseCodeMap.put('Р', ".-.");
        morseCodeMap.put('С', "...");
        morseCodeMap.put('Т', "-");
        morseCodeMap.put('У', "..-");
        morseCodeMap.put('Ж', "...-");
        morseCodeMap.put('В', ".--");
        morseCodeMap.put('Ь', "-..-");
        morseCodeMap.put('Ы', "-.--");
        morseCodeMap.put('З', "--..");
        morseCodeMap.put('Ч', "---.");
        morseCodeMap.put('Ш', "----");
        morseCodeMap.put('Э', "..-..");
        morseCodeMap.put('Ю', "..--");
        morseCodeMap.put('Я', ".-.-");

        // lowercase English
        morseCodeMap.put('a', ".-");
        morseCodeMap.put('b', "-...");
        morseCodeMap.put('c', "-.-.");
        morseCodeMap.put('d', "-..");
        morseCodeMap.put('e', ".");
        morseCodeMap.put('f', "..-.");
        morseCodeMap.put('g', "--.");
        morseCodeMap.put('h', "....");
        morseCodeMap.put('i', "..");
        morseCodeMap.put('j', ".---");
        morseCodeMap.put('k', "-.-");
        morseCodeMap.put('l', ".-..");
        morseCodeMap.put('m', "--");
        morseCodeMap.put('n', "-.");
        morseCodeMap.put('o', "---");
        morseCodeMap.put('p', ".--.");
        morseCodeMap.put('q', "--.-");
        morseCodeMap.put('r', ".-.");
        morseCodeMap.put('s', "...");
        morseCodeMap.put('t', "-");
        morseCodeMap.put('u', "..-");
        morseCodeMap.put('v', "...-");
        morseCodeMap.put('w', ".--");
        morseCodeMap.put('x', "-..-");
        morseCodeMap.put('y', "-.--");
        morseCodeMap.put('z', "--..");

        // lowercase Rus
        morseCodeMap.put('а', ".-");
        morseCodeMap.put('б', "-...");
        morseCodeMap.put('ц', "-.-.");
        morseCodeMap.put('д', "-..");
        morseCodeMap.put('е', ".");
        morseCodeMap.put('ф', "..-.");
        morseCodeMap.put('г', "--.");
        morseCodeMap.put('х', "....");
        morseCodeMap.put('и', "..");
        morseCodeMap.put('й', ".---");
        morseCodeMap.put('к', "-.-");
        morseCodeMap.put('л', ".-..");
        morseCodeMap.put('м', "--");
        morseCodeMap.put('н', "-.");
        morseCodeMap.put('о', "---");
        morseCodeMap.put('п', ".--.");
        morseCodeMap.put('щ', "--.-");
        morseCodeMap.put('р', ".-.");
        morseCodeMap.put('с', "...");
        morseCodeMap.put('т', "-");
        morseCodeMap.put('у', "..-");
        morseCodeMap.put('ж', "...-");
        morseCodeMap.put('в', ".--");
        morseCodeMap.put('ь', "-..-");
        morseCodeMap.put('ы', "-.--");
        morseCodeMap.put('з', "--..");
        morseCodeMap.put('ч', "---.");
        morseCodeMap.put('ш', "----");
        morseCodeMap.put('э', "..-..");
        morseCodeMap.put('ю', "..--");
        morseCodeMap.put('я', ".-.-");

        // numbers
        morseCodeMap.put('0', "-----");
        morseCodeMap.put('1', ".----");
        morseCodeMap.put('2', "..---");
        morseCodeMap.put('3', "...--");
        morseCodeMap.put('4', "....-");
        morseCodeMap.put('5', ".....");
        morseCodeMap.put('6', "-....");
        morseCodeMap.put('7', "--...");
        morseCodeMap.put('8', "---..");
        morseCodeMap.put('9', "----.");

        // special characters
        morseCodeMap.put(' ', "/");
        morseCodeMap.put(',', "--..--");
        morseCodeMap.put('.', ".-.-.-");
        morseCodeMap.put('?', "..--..");
        morseCodeMap.put(';', "-.-.-.");
        morseCodeMap.put(':', "---...");
        morseCodeMap.put('(', "-.--.");
        morseCodeMap.put(')', "-.--.-");
        morseCodeMap.put('[', "-.--.");
        morseCodeMap.put(']', "-.--.-");
        morseCodeMap.put('{', "-.--.");
        morseCodeMap.put('}', "-.--.-");
        morseCodeMap.put('+', ".-.-.");
        morseCodeMap.put('-', "-....-");
        morseCodeMap.put('_', "..--.-");
        morseCodeMap.put('"', ".-..-.");
        morseCodeMap.put('\'', ".----.");
        morseCodeMap.put('/', "-..-.");
        morseCodeMap.put('\\', "-..-.");
        morseCodeMap.put('@', ".--.-.");
        morseCodeMap.put('=', "-...-");
        morseCodeMap.put('!', "-.-.--");
    }

    public String translateToMorse(String textToTranslate){
        StringBuilder translatedText = new StringBuilder();
        for(Character letter : textToTranslate.toCharArray()){
            // translate the letter and then append to the returning value (to be displayed to the GUI)
            translatedText.append(morseCodeMap.get(letter) + " ");
        }
        return translatedText.toString();
    }

    // morseMessage - contains the morse message after being translated
    public void playSound(String[] morseMessage) throws LineUnavailableException, InterruptedException {
        // audio format specifies the audio properties (i.e. the type of sound we want)
        AudioFormat audioFormat = new AudioFormat(44100, 16, 1, true, false);

        // create the data line (to play incoming audio data)
        DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
        SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
        sourceDataLine.open(audioFormat);
        sourceDataLine.start();

        // duration of the sound to be played (I just messed around with the values to get it close enough)
        int dotDuration = 200;
        int dashDuration = (int) (1.5 * dotDuration);
        int slashDuration = 2 * dashDuration;

        for(String pattern : morseMessage){
            System.out.println(pattern);

            // play the letter sound
            for(char c : pattern.toCharArray()){
                if(c == '.'){
                    playBeep(sourceDataLine, dotDuration);
                    Thread.sleep(dotDuration);
                }else if(c == '-'){
                    playBeep(sourceDataLine, dashDuration);
                    Thread.sleep(dotDuration);
                }else if(c == '/'){
                    Thread.sleep(slashDuration);
                }
            }

            // waits a bit before playing the next sequence
            Thread.sleep(dotDuration);
        }

        // close audio output line (cleans up resources)
        sourceDataLine.drain();
        sourceDataLine.stop();
        sourceDataLine.close();
    }

    // sends audio data to be played to the data line
    private void playBeep(SourceDataLine line, int duration){
        // create audio data
        byte[] data = new byte[duration * 44100 / 1000];

        for(int i = 0; i < data.length; i++){
            // calculates the angle of the sine wave for the current sample based on the sample rate and frequency
            double angle = i / (44100.0/440) * 2.0 * Math.PI;

            // calculates the amplitude of the sine wave at the current angle and scale it to fit within the range of
            // a signed byte (-128, 127)
            // also in the context of audio processing, a signed bytes is often used to represent audio data because it
            // can represent both positive and negative amplitudes of sound waves
            data[i] = (byte) (Math.sin(angle) * 127.0);
        }

        // write the audio dat in the data line to be played
        line.write(data, 0, data.length);
    }
}
