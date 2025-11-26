#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void generate_hints(char* hidden, char* guess, char* hints) {
    int len = strlen(hidden);
    int hidden_used[100] = {0};
    int guess_used[100] = {0};
    
    
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
            for (int j = 0; j < len; j++) {
                if (!hidden_used[j] && guess[i] == hidden[j] && !guess_used[i]) {
                    hints[i] = 'y';
                    hidden_used[j] = 1;
                    guess_used[i] = 1;
                    break;
                }
            }
        }
    }

}

int main(int argc, char** argv) {
    
    if (argc < 2){
        printf("usage: %s guess_word hints_string\n", argv[0]);
        return 1;
    }
    
    char* guess = argv[1];
    char* target_hints = argv[2];
    
    if (strlen(guess) != strlen(target_hints)) {
        printf("error : guess word and hints string must be the same length\n");
        return 1;
    }
    
 
    for (int i = 0; i < strlen(target_hints); i++) {
        if (target_hints[i] != 'g' && target_hints[i] != 'y' && target_hints[i] != 'r') {
            printf("error : hints string contains invalid character %c\n", target_hints[i]);
            return 1;
        }
    }
    
    char next[6]; 
    int found_count = 0;
    int len = strlen(guess);
    
    while (scanf("%5s", next) == 1) { 
        if (strlen(next) == len) {
            char actual_hints[6];
            generate_hints(next, guess, actual_hints);
            if (strcmp(actual_hints, target_hints) == 0) {
                printf("%s ", next);
                found_count++;
            }
        }
    }
    
    if (found_count == 0) {
        printf("No possible hidden words found.");
    }
    printf("\n");
    
    return 0;

}