#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX_POINTS 100000 

int main(int argc, char** argv) {
    
    if (argc < 2){
        printf("usage: %s hidden_word guess_word\n", argv[0]);
        return 1;
    }
    
    char* hidden = argv[1];
    char* guess = argv[2];
    int len = strlen(hidden);
    
    if (strlen(hidden) != strlen(guess)) {
        printf("error : hidden word is not the same length as the guess word\n");
        return 1;
    }

    for (int i = 0; i < len; i++) {
        if (hidden[i] < 'a' || hidden[i] > 'z') {
            printf("error : hidden word contains the invalid character %c\n", hidden[i]);
            return 1;
        }
        if (guess[i] < 'a' || guess[i] > 'z') {
            printf("error : guess word contains the invalid character %c\n", guess[i]);
            return 1;
        }
    }
    
    
    char hints[MAX_POINTS];
    int hidden_used[MAX_POINTS] = {0};
    int guess_used[MAX_POINTS] = {0};
    
    
    for (int i = 0; i < len; i++) {
        if (guess[i] == hidden[i]) {
            hints[i] = 'g';
            hidden_used[i] = 1;
            guess_used[i] = 1;
        } else {
            hints[i] = 'r'; 
        }
    }
    
    
    for (int i = 0; i < len; i++) {
        if (hints[i] == 'g') continue; 
        
        for (int j = 0; j < len; j++) {
            if (!hidden_used[j] && guess[i] == hidden[j] && !guess_used[i]) {
                
                int hidden_count = 0;
                for (int k = 0; k < len; k++) {
                    if (hidden[k] == guess[i]) {
                        hidden_count++;
                    }
                }
                
                
                int marked_count = 0;
                for (int k = 0; k < len; k++) {
                    if (guess[k] == guess[i] && (hints[k] == 'g' || hints[k] == 'y')) {
                        marked_count++;
                    }
                }
                
               
                if (marked_count < hidden_count) {
                    hints[i] = 'y';
                    hidden_used[j] = 1;
                    guess_used[i] = 1;
                    break;
                }
            }
        }
    }
    
    hints[len] = '\0'; 
    printf("The hints are %s.\n", hints);
    
    return 0;
}