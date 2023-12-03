/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Generator;

import java.util.Random;
import java.util.UUID;

/**
 *
 * @author user
 */
public class generator {
     String uniqueID = UUID.randomUUID().toString();

    public generator() {
    }
    
    public String getId() {
        Random r = new Random();
        char a = (char)(r.nextInt(26) + 'a');
        char b = (char)(r.nextInt(26) + 'a');
        char c = (char) (r.nextInt(26) + 'a');
        char d = (char) (r.nextInt(26) + 'a');
        
        String randomString = "" + a + b + c;
        String randomChar = "" + d;
        
        String time = "" + System.currentTimeMillis();
        
        String id = randomString + time.substring(time.length() - 3, time.length()) + randomChar;

        return id;
    }
    
}
