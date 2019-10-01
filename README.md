# Permutations

Computer programs for the Permutation Cipher based on Z29 as in Problem 1. In encryption program, the inputs are a value of m (the size of permutation), a permutation as the key and the plaintext, and the output is the ciphertext. Write the decryption program accordingly. Try your programs by some text. Note that since m and the length of plaintext is not ﬁxed, paddings might be added to the end of plaintext by the program. You may think about what kind padding is better for the security and design your paddings.

Solution Description: 
STEP 1: Initialize array to m = 6. Then we shuffled the array by passing key along with the text.
STEP2: We then check the size of the block and padded the last block of the array. This is been stored in an empty string which is used for while execution. 
STEP 3: We have looped the whole block and converted the block into strings. In addition to this, we have made  the array of block and traversed along with the key size using keys position as well as the block  element. It is done so to as it come in output and put in string c for decryption.

FUNCTIONS USED:
There are four main functions used while computing the permutation cipher code.
1.	Shuffle function – In the shuffle function we generate random alphabets  and perform basic swap operation on the array. Here the plain text is written in a prearranged manner. 
2.	Encrypt function – The plain text is encrypted using a key where the size should not be greater than 6. If while dividing the block using all sets of permutations, the characters require padding then the remaining spaces will be append by “$” symbol. For this we required two fr loops for position and the block.
3.	Decrypt function – In the decrypt function the cipher text is decrypted back to the original plain text. It will trace back posistion by position to decrypt the cipher text.
4.	Inverse_key – We inverse the key calculated above and determine the position of the elements in the key as well as the position of the cipher text. 
