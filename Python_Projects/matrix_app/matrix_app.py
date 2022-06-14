"""
Author: Lindley, Thomas
Date 02 April 2021
matrix_app.py preforms multiple opperations on Matrices
"""

import sys
import re
import numpy as np
from pandas.core.frame import DataFrame as df

def do_you_play():
    """Function to either allow user to play or quit"""
    while True:
        play = input('\nDo you want to play the Matrix Game?\n'
            'Enter Y for yes or N for No:\n').upper()
        if play in ('Y', 'N'):
            break
        print('Please enter Y or N')
    return play

def phone_number():
    """Function that takes in phone number and checks format"""
    print('\nPlease enter your phone number (XXX-XXX-XXXX):')
    while True:
        p_number = input()
        if re.fullmatch(r'\d{3}-\d{3}-\d{4}', p_number):
            print('Phone number accepted.\n')
            break
        print('Invalid phone number format, please renter:')

def zip_code():
    """Function that takes in zipcode and checks format"""
    print('Please enter your Zip-code (XXXXX-XXXX):')
    while True:
        zipcode = input()
        if re.fullmatch(r'\d{5}-\d{4}', zipcode):
            print('Zipcode accepted.')
            break
        print('Invalid Zip-code format, please renter:')

def matrix_create():
    """function that creates a 3X3 matrix in a Pandas DataFrame"""
    print('\nPlease enter your 3X3 matrix, integers or floats allowed '
        '(\nSpaces between each column and new line for rows):')
    while True:
        try:
            # create 0 3x3 array first
            usr_matrix = np.zeros((3,3), dtype = float)
            for i in range(3):
                usr_matrix[i] = input().split(' ')
            # cast to data frame
            df_matrix = df(usr_matrix)
            return df_matrix
        except ValueError:
            print('Matrix not valid, please check spacing and ensure it '
            'is 3X3 (integers or floats only).\n''Please Renter:')
            continue

def matrix_add(a_matrix, b_matrix):
    """function that adds two matrices together"""
    added_matrix = df.add(a_matrix, b_matrix)
    print('\nYou selected matrix addition, the results are:\n' +
        clean_output(added_matrix))
    print('\nThe Transpose is:\n' +
        clean_output(df.transpose(added_matrix)))
    mean_matrix(added_matrix)

def matrix_sub(a_matrix, b_matrix):
    """function that subtracts a matrix from another"""
    subtracted_matrix = df.subtract(a_matrix, b_matrix)
    print('\nYou selected matrix subtraction, the results are:\n' +
        clean_output(subtracted_matrix))
    print('\nThe Transpose is:\n' +
        clean_output(df.transpose(subtracted_matrix)))
    mean_matrix(subtracted_matrix)

def matrix_multi(a_matrix, b_matrix):
    """function that multiplies two matrices"""
    multi_matrix = np.matmul(a_matrix, b_matrix)
    print('\nYou selected matrix multiplication, the results are:\n' +
        clean_output(multi_matrix))
    print('\nThe Transpose is:\n' +
        clean_output(df.transpose(multi_matrix)))
    mean_matrix(multi_matrix)

def matrix_elem_multi(a_matrix, b_matrix):
    """function that elementwise multiplies two matrices"""
    elem_multi_matrix = df.multiply(a_matrix, b_matrix)
    print('\nYou selected element by element matrix multiplication, the results are:\n' +
        clean_output(elem_multi_matrix))
    print('\nThe Transpose is:\n' +
        clean_output(df.transpose(elem_multi_matrix)))
    mean_matrix(elem_multi_matrix)

def mean_matrix(any_matrix_mean):
    """Function that calculates and cleanly outputs the mean of a matrix"""
    print('\nThe row and column mean values of the results are:\n' +
    'Row: ' + str(any_matrix_mean.mean(axis= 1).round(2).tolist())[1:-1] +
    '\nColumn: ' + str(any_matrix_mean.mean(axis= 0).round(2).tolist())[1:-1])

def clean_output(dirty_matrix):
    """Function that cleans output"""
    return dirty_matrix.to_string(index = False, header = False)

print('****** Welcome to the Python Matrix Application ******')

# while loop runs until user enters N, then sys exit
while True:
    plays = do_you_play()

    if plays == 'Y':
        phone_number()
        zip_code()

        # matrix creation and print
        matrix_a = matrix_create()
        print('\nYour first matrix:\n' +
            clean_output(matrix_a))
        
        matrix_b = matrix_create()
        print('\nYour second matrix:\n' +
            clean_output(matrix_b))

        print('\nSelect a matrix Operation from the list below:')

        # secondary while loop that runs until user makes a valid choice
        while True:
            usr_choice = input('a. Addition\n'
            'b. Subtraction\n'
            'c. Matrix Multiplication\n'
            'd. Element by Element Multiplication\n').lower()

            # pass matrices to proper function for proccessing
            if usr_choice == 'a':
                matrix_add(matrix_a, matrix_b)
            elif usr_choice == 'b':
                matrix_sub(matrix_a, matrix_b)
            elif usr_choice == 'c':
                matrix_multi(matrix_a, matrix_b)
            elif usr_choice == 'd':
                matrix_elem_multi(matrix_a, matrix_b)
            else:
                print('Selection invalid, please choose from a to d:')
                continue
            break

    # exit program
    if plays == 'N':
        print('******Thanks for playing Python Numpy******')
        sys.exit()
