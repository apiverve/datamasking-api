from setuptools import setup, find_packages

setup(
    name='apiverve_datamasking',
    version='1.2.2',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Data Masking redacts sensitive data like emails, phone numbers, payment cards, IP addresses, and dates using placeholder tokens. It returns the sanitized string and detection counts for each pattern found.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/datamasking?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
