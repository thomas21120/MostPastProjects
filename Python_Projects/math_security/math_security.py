"""math_security.py allows users to solve a few math problems,
and generate secure passwords"""

import sys
import string
import secrets
import datetime
import math

def int_or_float(numbers):
    """int_or_float allows the acception of float and int values from user input"""
    try:
        value = int(numbers)
    except ValueError:
        pass
    try:
        value = float(numbers)
    except ValueError:
        pass
    return value

def alpha_creator(upper, lower, digits, special):
    """Creates alphabet for password_gen."""
    alphabet = ''
    if upper:
        alphabet += string.ascii_uppercase
    if lower:
        alphabet += string.ascii_lowercase
    if digits:
        alphabet += string.digits
    if special:
        alphabet += string.punctuation
    return alphabet

def password_gen(upper, lower, digits, special, length):
    """Generates a secure password using alphabet created and secrets."""
    alphabet = alpha_creator(upper, lower, digits, special)
    while True:
        password = ''.join(secrets.choice(alphabet)for i in range(length))
        if upper:
            if any(c.isupper() for c in password) is False:
                continue
        if lower:
            if any(c.islower() for c in password) is False:
                continue
        if digits:
            if any(c.isdigit() for c in password) is False:
                continue
        if special:
            if any(c in string.punctuation for c in password) is False:
                continue
        break
    return password

def percentage_calc(num, denom, decimal_p):
    """Calculates percentage and formats the output."""
    percent = (num/denom)*100
    return str(round(percent, decimal_p))

def find_days_until():
    """Finds days until July 4, 2025."""
    today = datetime.date.today()
    july_day = datetime.date(2025, 7, 4)
    days_until = (july_day - today).days
    return days_until

def law_cosines(side_a, side_b, angle_c, decimal_p):
    """Finds missing leg of triangle with law of cosines."""
    side_c = math.sqrt((side_a**2 + side_b**2) -
    (2*side_a*side_b*math.cos(math.radians(angle_c))))
    return str(round(side_c, decimal_p))

def volume_cylinder(radius, height, decimal_p):
    """Finds the volume of a right circular cylinder."""
    volume = (math.pi * radius**2 * height)
    return str(round(volume, decimal_p))


print('************************************************************************\n'
'Welcome to the math problem solving amd password generating program.')

while True:
    user_choice = input('Please choose from the following selection:\n'
    'a. Generate Secure Password\n'
    'b. Calculate and Format Percentage\n'
    'c. How many days from today until July 4, 2025?\n'
    'd. Use the Law of Cosines to calculate the leg of a triangle.\n'
    'e. Calculate the volume of a Right Circular Cylinder\n'
    'f. Exit program\n').upper()

# Check for valid selection
    if user_choice < 'A' or user_choice > 'F':
        print('Please choose from a to f (not case sensitive).\n')
        continue

# Generate password choice selected.
    if user_choice == 'A':
        print('\n***Genearate Secure Password***')
        while True:
            print('Please answer questions to define the complexity of password.')
            # Ensure user does not just press enter, breaks program
            try:
                pass_upper = input('Use uppercase letters? Y/N\n').upper()[0]
                pass_lower = input('Use lowecase letters? Y/N\n').upper()[0]
                pass_digits = input('Use numbers? Y/N\n').upper()[0]
                pass_special = input('Use special charecters? Y/N\n').upper()[0]
            except IndexError:
                print('---Please make a selection of Yes or No for the questions---')
                continue
            # Ensure password length is an integer.
            try:
                pass_length = int(input('Password length '
                'must be integers only, must at least 4 charecters long!\n'))
                if pass_length < 4:
                    print('---Password must be at least 4 charecters long!---\n')
                    continue
            except ValueError:
                print('---Password length must be integers.---\n')
                continue
            # Ensure user entered something that begins with y or n
            if (pass_upper not in ['Y', 'N'] or pass_lower not in ['Y', 'N'] or
            pass_digits not in ['Y', 'N'] or pass_special not in ['Y', 'N']):
                print('---Pleas enter Y/N or yes/no, case does not matter.---\n')
                continue
            # Output Password
            print('\nYour Password is: ' +
            password_gen((pass_upper=='Y'), (pass_lower=='Y'),
            (pass_digits=='Y'), (pass_special=='Y'), pass_length) + '\n')
            input('Press enter to continue...\n')
            break

# Calculate Percentages
    elif user_choice == 'B':
        print('\n***Calculate and Format Percentage***')
        while True:
            print('To find A as a percentage of B (integer or decimal numbers):')
            # Ensure valid inputs
            try:
                usr_numerator = int_or_float(input('Please enter A:\n'))
                usr_denominator = int_or_float(input('Please enter B:\n'))
                usr_decimal_place = int(input('Please enter decimal place'
                ' to round to (integer only):\n'))
                # Ensure decimal place is not less than zero
                if usr_denominator == 0 or usr_decimal_place < 0:
                    print('---B cannot be zero and decimal place to round to can'
                    ' not be less than zero.---')
                    continue
                # output calculated percentage
                print('\nThe percent of A/B is: ' +
                percentage_calc(usr_numerator, usr_denominator, usr_decimal_place) +
                '%' + '\n')
                input('Press enter to continue...\n')
                break
            except (ValueError, UnboundLocalError):
                print('---Please enter integers or decimal numbers only'
                ' (integer only for decimal place).---\n')
                continue

# Days until July 4, 2025
    elif user_choice == 'C':
        print('\n***How many days from today until July 4, 2025?***'
        f"\nThere are {find_days_until()} left from today to July, 4, 2025\n")
        input('Press enter to continue...\n')

# Law of Cosines
    elif user_choice == 'D':
        print('\n***Use the Law of Cosines to calculate missing side of a triangle***')
        while True:
            print('In order to use the law of cosines you need the length of side A and B, '
            'and the angle C,\nwhich is the angle opposite of'
            ' side C (integer or decimal numbers)')
            # Ensure valid inputs
            try:
                usr_side_a = int_or_float(input('Please enter side A:\n'))
                usr_side_b = int_or_float(input('Please enter side B:\n'))
                usr_angle_c = int_or_float(input('please enter angle C in degrees:\n'))
                usr_t_decimal_place = int(input('Please enter to what decimal'
                ' place you would like to round to (integer only):\n'))
                if ((usr_side_a <= 0) or (usr_side_b <= 0) or
                (usr_angle_c <= 0) or (usr_t_decimal_place < 0)):
                    print('---Please enter measurements that are greater than zero,'
                    ' and decimal place to round to can not be less than zero.---\n')
                    continue
                # Output length of missing side
                print('The length of side C is: ' +
                law_cosines(usr_side_a, usr_side_b, usr_angle_c, usr_t_decimal_place))
                input('Press enter to continue...\n')
                break
            except (UnboundLocalError, ValueError):
                print('---Please enter either decimal numbers or integers for sides and angles,'
                '\nand integers only for decimal place to round to.---\n')

# Volume of right cylinder
    elif user_choice == 'E':
        print('\n***Calculate the volume of a Right Circular Cylinder***\n'
        'In order to determine the volume of the Right Circular Cylinder you'
        ' will need the radius and the height (integer or decimal number).')
        while True:
            # Ensure valid input
            try:
                usr_radius = int_or_float(input('Please enter the radius:\n'))
                usr_height = int_or_float(input('Please enter the height:\n'))
                usr_c_decimal = int(input('Please enter decimal place to round to'
                ' (integer only):\n'))
                if usr_radius <= 0 or usr_height <= 0 or usr_c_decimal < 0:
                    print('---Please enter valid measurements (more than zero), '
                    'and ensure decimal place choice is not less than zero.---')
                    continue
                # Output volume
                print('The volume of the given cylinder is: ' +
                volume_cylinder(usr_radius, usr_height, usr_c_decimal) + ' Units Cubed')
                input('Press enter to continue...\n')
                break
            except (UnboundLocalError, ValueError):
                print('---Please enter integers or decimal numbers only'
                ' (integer only for decimal place)---\n')

# Exit program
    elif user_choice == 'F':
        print('\n***Thank you for using the math problem solving and '
        'password generating program!***\n')
        sys.exit()
