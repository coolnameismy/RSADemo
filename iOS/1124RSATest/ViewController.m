//
//  ViewController.m

//
//  Created by liuyanwei on 17/1/23.
//  Copyright (c) 2017年 liuyanwei. All rights reserved.
//

#import "ViewController.h"
#import "RSAEncryptor.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    [self runRSA];
    
}
- (void)runRSA {
    
    RSAEncryptor *rsa = [[RSAEncryptor alloc] init];
    
    //设置公私匙
    [rsa loadPublicKeyFromFile:[[NSBundle mainBundle] pathForResource:@"public_key" ofType:@"der"]];
    [rsa loadPrivateKeyFromFile:[[NSBundle mainBundle] pathForResource:@"private_key" ofType:@"p12"] password:@""];
    
    //加密
    NSString *originText = @"hello liuyanwei";
    NSString *encryptedString = [rsa rsaEncryptString:originText];
    //解密
    NSString *decryptedString = [rsa rsaDecryptString:encryptedString];

    //显示加密和解密的数据
    NSLog(@"origin data: %@", originText);
    NSLog(@"encrypted data: %@", encryptedString);
    NSLog(@"decrypted data: %@", decryptedString);

}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
