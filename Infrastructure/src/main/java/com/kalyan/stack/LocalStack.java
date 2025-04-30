package com.kalyan.stack;

import software.amazon.awscdk.App;
import software.amazon.awscdk.AppProps;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;

public class LocalStack extends Stack {
    public LocalStack(final App scope, final String id, final StackProps props){
        super(scope,id,props);
    }
    public static void main(final String[] args){
        //App app = new App(AppProps.builder().outdir("*./cdk.out").build();

    }
}
